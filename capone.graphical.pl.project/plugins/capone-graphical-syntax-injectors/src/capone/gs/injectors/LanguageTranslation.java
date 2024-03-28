package capone.gs.injectors;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Properties;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.sirius.viewpoint.description.Group;

import capone.gs.injector.IGraphicalStyle;

public class LanguageTranslation implements IGraphicalStyle {
	
	@Override
	public Group modifyGraphicalSpecification(Group group, Map<String,String> parameterValues) {
		Pattern pattern1 = Pattern.compile("'(.+?)'",   Pattern.DOTALL);
		Pattern pattern2 = Pattern.compile("\"(.+?)\"", Pattern.DOTALL);
		Matcher matcher  = null;
		Map<String,String> dictionary = new HashMap<>();
		// obtain target language selected by the user
		String language = parameterValues.get("Target language");
		// translate graphical syntax into selected target language
		Group newGroup = EcoreUtil.copy(group);
		TreeIterator<EObject> contentIterator = newGroup.eAllContents();
		while (contentIterator.hasNext()) {
			EObject gObject = contentIterator.next();
			for (EStructuralFeature gFeature : gObject.eClass().getEAllStructuralFeatures()) {
				String featureName = gFeature.getName();
				if (featureName.equals("labelExpression")) {
					String value = (String)gObject.eGet(gFeature);
					if (value!=null && !value.isBlank()) {
						dictionary.clear();
						
						// translation when value is string => translate full string
						if (!value.startsWith("aql:")) {
							dictionary.put(value, this.translation(value, language));
						}
						
						// translation when value is aql expression => translate substrings between '' and "" 
						else {
							matcher = pattern1.matcher(value); 
							matcher.results().map(MatchResult::group).forEach(word -> dictionary.put(word, translation(word, language)));
							matcher = pattern2.matcher(value); 
							matcher.results().map(MatchResult::group).forEach(word -> dictionary.put(word, translation(word, language)));
						}
						
						// replace translations in label expression
						for (String word : dictionary.keySet()) {		
							System.out.println("*** replacing " + word + " by " + dictionary.get(word));
							value = value.replaceAll(word, dictionary.get(word));
						}						
						gObject.eSet(gFeature, value);
					}
				}
			}
		}
		return newGroup;
	}
	
	/**
	 * It translates a word into a given language.
	 */
	private String translation (String word, String language) {
		String enclosingSymbol = "";
		if      (word.startsWith("'"))  enclosingSymbol = "'";
		else if (word.startsWith("\"")) enclosingSymbol = "\"";
		String wordWithoutQuotes = enclosingSymbol.isEmpty()? word : word.substring(1, word.length()-1); 
		String translation       = translationWithOpenAI(wordWithoutQuotes, language);
		if (wordWithoutQuotes.startsWith(" ") && !translation.startsWith(" ")) translation = " " + translation;
		if (wordWithoutQuotes.endsWith(" ")   && !translation.endsWith(" "))   translation = translation + " ";
		return enclosingSymbol + translation + enclosingSymbol;
	}
	
	/**
	 * Translation using OpenAI
	 */
	public String translationWithOpenAI (String word, String language) {
	       String url    = "https://api.openai.com/v1/chat/completions";
	       String model  = "gpt-3.5-turbo";
	       String prompt = "Translate '" + word + "' into " + language + ", tell me only the translation";
	       String apiKey = "";
	       
	       try {
		       // read API key from config.properties file
		       Properties properties = new Properties();
		       InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties");
		       if (input!=null) {
		    	   properties.load(input);
		    	   apiKey = properties.getProperty("apiKey");
		       }

	           URL obj = new URL(url);
	           HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
	           connection.setRequestMethod("POST");
	           connection.setRequestProperty("Authorization", "Bearer " + apiKey);
	           connection.setRequestProperty("Content-Type", "application/json");

	           // The request body
	           String body = "{\"model\": \"" + model + "\", \"messages\": [{\"role\": \"user\", \"content\": \"" + prompt + "\"}]}";
	           connection.setDoOutput(true);
	           OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
	           writer.write(body);
	           writer.flush();
	           writer.close();

	           // Response from ChatGPT
	           BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	           String line;
	           StringBuffer response = new StringBuffer();
	           while ((line = br.readLine()) != null) {
	               response.append(line);
	           }
	           br.close();

	           // calls the method to extract the message.
		       int start = response.indexOf("content")+11;
		       int end = response.indexOf("\"", start);
		       return response.substring(start, end);

	       } 
	       catch (IOException e) {
	           System.err.println("ERROR: " + e.getMessage());
	       }
	       
	       // return original word in case of errors
	       return word;
	   }
}