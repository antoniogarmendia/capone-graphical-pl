package capone.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import capone.services.CaponeDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalCaponeDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'top'", "'Module'", "'{'", "'formula'", "'metamodel'", "'extends.mandatory'", "','", "'extends.optional'", "'extends.alternative'", "'extends.or'", "'rules'", "'diagram'", "'}'", "'override'", "'merge'", "'('", "')'", "'.'", "'extends'", "'not'", "'and'", "'or'", "'implies'"
    };
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalCaponeDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalCaponeDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalCaponeDslParser.tokenNames; }
    public String getGrammarFileName() { return "InternalCaponeDsl.g"; }



     	private CaponeDslGrammarAccess grammarAccess;

        public InternalCaponeDslParser(TokenStream input, CaponeDslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Module";
       	}

       	@Override
       	protected CaponeDslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModule"
    // InternalCaponeDsl.g:65:1: entryRuleModule returns [EObject current=null] : iv_ruleModule= ruleModule EOF ;
    public final EObject entryRuleModule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModule = null;


        try {
            // InternalCaponeDsl.g:65:47: (iv_ruleModule= ruleModule EOF )
            // InternalCaponeDsl.g:66:2: iv_ruleModule= ruleModule EOF
            {
             newCompositeNode(grammarAccess.getModuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModule=ruleModule();

            state._fsp--;

             current =iv_ruleModule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModule"


    // $ANTLR start "ruleModule"
    // InternalCaponeDsl.g:72:1: ruleModule returns [EObject current=null] : ( ( (lv_isTop_0_0= 'top' ) )? otherlv_1= 'Module' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => ( (otherlv_5= 'formula' ( (lv_formula_6_0= ruleFormula ) ) )? (otherlv_7= 'metamodel' ( (lv_metamodel_8_0= ruleEString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'extends.mandatory' ( ( ruleEString ) ) (otherlv_11= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'extends.optional' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'extends.alternative' ( ( ruleEString ) ) (otherlv_19= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'extends.or' ( ( ruleEString ) ) (otherlv_23= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'rules' ( (lv_rules_26_0= ruleRuleSet ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= 'diagram' ( (lv_chooseDiagram_28_0= ruleDiagram ) ) ) ) ) ) )+ {...}?) ) ) otherlv_29= '}' ) ;
    public final EObject ruleModule() throws RecognitionException {
        EObject current = null;

        Token lv_isTop_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_25=null;
        Token otherlv_27=null;
        Token otherlv_29=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_formula_6_0 = null;

        AntlrDatatypeRuleToken lv_metamodel_8_0 = null;

        EObject lv_rules_26_0 = null;

        EObject lv_chooseDiagram_28_0 = null;



        	enterRule();

        try {
            // InternalCaponeDsl.g:78:2: ( ( ( (lv_isTop_0_0= 'top' ) )? otherlv_1= 'Module' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => ( (otherlv_5= 'formula' ( (lv_formula_6_0= ruleFormula ) ) )? (otherlv_7= 'metamodel' ( (lv_metamodel_8_0= ruleEString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'extends.mandatory' ( ( ruleEString ) ) (otherlv_11= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'extends.optional' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'extends.alternative' ( ( ruleEString ) ) (otherlv_19= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'extends.or' ( ( ruleEString ) ) (otherlv_23= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'rules' ( (lv_rules_26_0= ruleRuleSet ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= 'diagram' ( (lv_chooseDiagram_28_0= ruleDiagram ) ) ) ) ) ) )+ {...}?) ) ) otherlv_29= '}' ) )
            // InternalCaponeDsl.g:79:2: ( ( (lv_isTop_0_0= 'top' ) )? otherlv_1= 'Module' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => ( (otherlv_5= 'formula' ( (lv_formula_6_0= ruleFormula ) ) )? (otherlv_7= 'metamodel' ( (lv_metamodel_8_0= ruleEString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'extends.mandatory' ( ( ruleEString ) ) (otherlv_11= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'extends.optional' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'extends.alternative' ( ( ruleEString ) ) (otherlv_19= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'extends.or' ( ( ruleEString ) ) (otherlv_23= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'rules' ( (lv_rules_26_0= ruleRuleSet ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= 'diagram' ( (lv_chooseDiagram_28_0= ruleDiagram ) ) ) ) ) ) )+ {...}?) ) ) otherlv_29= '}' )
            {
            // InternalCaponeDsl.g:79:2: ( ( (lv_isTop_0_0= 'top' ) )? otherlv_1= 'Module' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => ( (otherlv_5= 'formula' ( (lv_formula_6_0= ruleFormula ) ) )? (otherlv_7= 'metamodel' ( (lv_metamodel_8_0= ruleEString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'extends.mandatory' ( ( ruleEString ) ) (otherlv_11= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'extends.optional' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'extends.alternative' ( ( ruleEString ) ) (otherlv_19= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'extends.or' ( ( ruleEString ) ) (otherlv_23= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'rules' ( (lv_rules_26_0= ruleRuleSet ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= 'diagram' ( (lv_chooseDiagram_28_0= ruleDiagram ) ) ) ) ) ) )+ {...}?) ) ) otherlv_29= '}' )
            // InternalCaponeDsl.g:80:3: ( (lv_isTop_0_0= 'top' ) )? otherlv_1= 'Module' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' ( ( ( ( ({...}? => ( ({...}? => ( (otherlv_5= 'formula' ( (lv_formula_6_0= ruleFormula ) ) )? (otherlv_7= 'metamodel' ( (lv_metamodel_8_0= ruleEString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'extends.mandatory' ( ( ruleEString ) ) (otherlv_11= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'extends.optional' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'extends.alternative' ( ( ruleEString ) ) (otherlv_19= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'extends.or' ( ( ruleEString ) ) (otherlv_23= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'rules' ( (lv_rules_26_0= ruleRuleSet ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= 'diagram' ( (lv_chooseDiagram_28_0= ruleDiagram ) ) ) ) ) ) )+ {...}?) ) ) otherlv_29= '}'
            {
            // InternalCaponeDsl.g:80:3: ( (lv_isTop_0_0= 'top' ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==11) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalCaponeDsl.g:81:4: (lv_isTop_0_0= 'top' )
                    {
                    // InternalCaponeDsl.g:81:4: (lv_isTop_0_0= 'top' )
                    // InternalCaponeDsl.g:82:5: lv_isTop_0_0= 'top'
                    {
                    lv_isTop_0_0=(Token)match(input,11,FOLLOW_3); 

                    					newLeafNode(lv_isTop_0_0, grammarAccess.getModuleAccess().getIsTopTopKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getModuleRule());
                    					}
                    					setWithLastConsumed(current, "isTop", lv_isTop_0_0 != null, "top");
                    				

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,12,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getModuleAccess().getModuleKeyword_1());
            		
            // InternalCaponeDsl.g:98:3: ( (lv_name_2_0= ruleEString ) )
            // InternalCaponeDsl.g:99:4: (lv_name_2_0= ruleEString )
            {
            // InternalCaponeDsl.g:99:4: (lv_name_2_0= ruleEString )
            // InternalCaponeDsl.g:100:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getModuleAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_5);
            lv_name_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getModuleRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"capone.CaponeDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getModuleAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalCaponeDsl.g:121:3: ( ( ( ( ({...}? => ( ({...}? => ( (otherlv_5= 'formula' ( (lv_formula_6_0= ruleFormula ) ) )? (otherlv_7= 'metamodel' ( (lv_metamodel_8_0= ruleEString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'extends.mandatory' ( ( ruleEString ) ) (otherlv_11= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'extends.optional' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'extends.alternative' ( ( ruleEString ) ) (otherlv_19= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'extends.or' ( ( ruleEString ) ) (otherlv_23= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'rules' ( (lv_rules_26_0= ruleRuleSet ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= 'diagram' ( (lv_chooseDiagram_28_0= ruleDiagram ) ) ) ) ) ) )+ {...}?) ) )
            // InternalCaponeDsl.g:122:4: ( ( ( ({...}? => ( ({...}? => ( (otherlv_5= 'formula' ( (lv_formula_6_0= ruleFormula ) ) )? (otherlv_7= 'metamodel' ( (lv_metamodel_8_0= ruleEString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'extends.mandatory' ( ( ruleEString ) ) (otherlv_11= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'extends.optional' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'extends.alternative' ( ( ruleEString ) ) (otherlv_19= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'extends.or' ( ( ruleEString ) ) (otherlv_23= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'rules' ( (lv_rules_26_0= ruleRuleSet ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= 'diagram' ( (lv_chooseDiagram_28_0= ruleDiagram ) ) ) ) ) ) )+ {...}?) )
            {
            // InternalCaponeDsl.g:122:4: ( ( ( ({...}? => ( ({...}? => ( (otherlv_5= 'formula' ( (lv_formula_6_0= ruleFormula ) ) )? (otherlv_7= 'metamodel' ( (lv_metamodel_8_0= ruleEString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'extends.mandatory' ( ( ruleEString ) ) (otherlv_11= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'extends.optional' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'extends.alternative' ( ( ruleEString ) ) (otherlv_19= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'extends.or' ( ( ruleEString ) ) (otherlv_23= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'rules' ( (lv_rules_26_0= ruleRuleSet ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= 'diagram' ( (lv_chooseDiagram_28_0= ruleDiagram ) ) ) ) ) ) )+ {...}?) )
            // InternalCaponeDsl.g:123:5: ( ( ({...}? => ( ({...}? => ( (otherlv_5= 'formula' ( (lv_formula_6_0= ruleFormula ) ) )? (otherlv_7= 'metamodel' ( (lv_metamodel_8_0= ruleEString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'extends.mandatory' ( ( ruleEString ) ) (otherlv_11= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'extends.optional' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'extends.alternative' ( ( ruleEString ) ) (otherlv_19= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'extends.or' ( ( ruleEString ) ) (otherlv_23= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'rules' ( (lv_rules_26_0= ruleRuleSet ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= 'diagram' ( (lv_chooseDiagram_28_0= ruleDiagram ) ) ) ) ) ) )+ {...}?)
            {
             
            				  getUnorderedGroupHelper().enter(grammarAccess.getModuleAccess().getUnorderedGroup_4());
            				
            // InternalCaponeDsl.g:126:5: ( ( ({...}? => ( ({...}? => ( (otherlv_5= 'formula' ( (lv_formula_6_0= ruleFormula ) ) )? (otherlv_7= 'metamodel' ( (lv_metamodel_8_0= ruleEString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'extends.mandatory' ( ( ruleEString ) ) (otherlv_11= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'extends.optional' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'extends.alternative' ( ( ruleEString ) ) (otherlv_19= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'extends.or' ( ( ruleEString ) ) (otherlv_23= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'rules' ( (lv_rules_26_0= ruleRuleSet ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= 'diagram' ( (lv_chooseDiagram_28_0= ruleDiagram ) ) ) ) ) ) )+ {...}?)
            // InternalCaponeDsl.g:127:6: ( ({...}? => ( ({...}? => ( (otherlv_5= 'formula' ( (lv_formula_6_0= ruleFormula ) ) )? (otherlv_7= 'metamodel' ( (lv_metamodel_8_0= ruleEString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'extends.mandatory' ( ( ruleEString ) ) (otherlv_11= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'extends.optional' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'extends.alternative' ( ( ruleEString ) ) (otherlv_19= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'extends.or' ( ( ruleEString ) ) (otherlv_23= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'rules' ( (lv_rules_26_0= ruleRuleSet ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= 'diagram' ( (lv_chooseDiagram_28_0= ruleDiagram ) ) ) ) ) ) )+ {...}?
            {
            // InternalCaponeDsl.g:127:6: ( ({...}? => ( ({...}? => ( (otherlv_5= 'formula' ( (lv_formula_6_0= ruleFormula ) ) )? (otherlv_7= 'metamodel' ( (lv_metamodel_8_0= ruleEString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_9= 'extends.mandatory' ( ( ruleEString ) ) (otherlv_11= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= 'extends.optional' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'extends.alternative' ( ( ruleEString ) ) (otherlv_19= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'extends.or' ( ( ruleEString ) ) (otherlv_23= ',' ( ( ruleEString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= 'rules' ( (lv_rules_26_0= ruleRuleSet ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= 'diagram' ( (lv_chooseDiagram_28_0= ruleDiagram ) ) ) ) ) ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=8;
                int LA7_0 = input.LA(1);

                if ( LA7_0 >= 14 && LA7_0 <= 15 && getUnorderedGroupHelper().canSelect(grammarAccess.getModuleAccess().getUnorderedGroup_4(), 0) ) {
                    alt7=1;
                }
                else if ( LA7_0 == 16 && getUnorderedGroupHelper().canSelect(grammarAccess.getModuleAccess().getUnorderedGroup_4(), 1) ) {
                    alt7=2;
                }
                else if ( LA7_0 == 18 && getUnorderedGroupHelper().canSelect(grammarAccess.getModuleAccess().getUnorderedGroup_4(), 2) ) {
                    alt7=3;
                }
                else if ( LA7_0 == 19 && getUnorderedGroupHelper().canSelect(grammarAccess.getModuleAccess().getUnorderedGroup_4(), 3) ) {
                    alt7=4;
                }
                else if ( LA7_0 == 20 && getUnorderedGroupHelper().canSelect(grammarAccess.getModuleAccess().getUnorderedGroup_4(), 4) ) {
                    alt7=5;
                }
                else if ( LA7_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getModuleAccess().getUnorderedGroup_4(), 5) ) {
                    alt7=6;
                }
                else if ( LA7_0 == 22 && getUnorderedGroupHelper().canSelect(grammarAccess.getModuleAccess().getUnorderedGroup_4(), 6) ) {
                    alt7=7;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalCaponeDsl.g:128:4: ({...}? => ( ({...}? => ( (otherlv_5= 'formula' ( (lv_formula_6_0= ruleFormula ) ) )? (otherlv_7= 'metamodel' ( (lv_metamodel_8_0= ruleEString ) ) ) ) ) ) )
            	    {
            	    // InternalCaponeDsl.g:128:4: ({...}? => ( ({...}? => ( (otherlv_5= 'formula' ( (lv_formula_6_0= ruleFormula ) ) )? (otherlv_7= 'metamodel' ( (lv_metamodel_8_0= ruleEString ) ) ) ) ) ) )
            	    // InternalCaponeDsl.g:129:5: {...}? => ( ({...}? => ( (otherlv_5= 'formula' ( (lv_formula_6_0= ruleFormula ) ) )? (otherlv_7= 'metamodel' ( (lv_metamodel_8_0= ruleEString ) ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getModuleAccess().getUnorderedGroup_4(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleModule", "getUnorderedGroupHelper().canSelect(grammarAccess.getModuleAccess().getUnorderedGroup_4(), 0)");
            	    }
            	    // InternalCaponeDsl.g:129:103: ( ({...}? => ( (otherlv_5= 'formula' ( (lv_formula_6_0= ruleFormula ) ) )? (otherlv_7= 'metamodel' ( (lv_metamodel_8_0= ruleEString ) ) ) ) ) )
            	    // InternalCaponeDsl.g:130:6: ({...}? => ( (otherlv_5= 'formula' ( (lv_formula_6_0= ruleFormula ) ) )? (otherlv_7= 'metamodel' ( (lv_metamodel_8_0= ruleEString ) ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getModuleAccess().getUnorderedGroup_4(), 0);
            	    					
            	    // InternalCaponeDsl.g:133:9: ({...}? => ( (otherlv_5= 'formula' ( (lv_formula_6_0= ruleFormula ) ) )? (otherlv_7= 'metamodel' ( (lv_metamodel_8_0= ruleEString ) ) ) ) )
            	    // InternalCaponeDsl.g:133:10: {...}? => ( (otherlv_5= 'formula' ( (lv_formula_6_0= ruleFormula ) ) )? (otherlv_7= 'metamodel' ( (lv_metamodel_8_0= ruleEString ) ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleModule", "true");
            	    }
            	    // InternalCaponeDsl.g:133:19: ( (otherlv_5= 'formula' ( (lv_formula_6_0= ruleFormula ) ) )? (otherlv_7= 'metamodel' ( (lv_metamodel_8_0= ruleEString ) ) ) )
            	    // InternalCaponeDsl.g:133:20: (otherlv_5= 'formula' ( (lv_formula_6_0= ruleFormula ) ) )? (otherlv_7= 'metamodel' ( (lv_metamodel_8_0= ruleEString ) ) )
            	    {
            	    // InternalCaponeDsl.g:133:20: (otherlv_5= 'formula' ( (lv_formula_6_0= ruleFormula ) ) )?
            	    int alt2=2;
            	    int LA2_0 = input.LA(1);

            	    if ( (LA2_0==14) ) {
            	        alt2=1;
            	    }
            	    switch (alt2) {
            	        case 1 :
            	            // InternalCaponeDsl.g:134:10: otherlv_5= 'formula' ( (lv_formula_6_0= ruleFormula ) )
            	            {
            	            otherlv_5=(Token)match(input,14,FOLLOW_7); 

            	            										newLeafNode(otherlv_5, grammarAccess.getModuleAccess().getFormulaKeyword_4_0_0_0());
            	            									
            	            // InternalCaponeDsl.g:138:10: ( (lv_formula_6_0= ruleFormula ) )
            	            // InternalCaponeDsl.g:139:11: (lv_formula_6_0= ruleFormula )
            	            {
            	            // InternalCaponeDsl.g:139:11: (lv_formula_6_0= ruleFormula )
            	            // InternalCaponeDsl.g:140:12: lv_formula_6_0= ruleFormula
            	            {

            	            												newCompositeNode(grammarAccess.getModuleAccess().getFormulaFormulaParserRuleCall_4_0_0_1_0());
            	            											
            	            pushFollow(FOLLOW_8);
            	            lv_formula_6_0=ruleFormula();

            	            state._fsp--;


            	            												if (current==null) {
            	            													current = createModelElementForParent(grammarAccess.getModuleRule());
            	            												}
            	            												set(
            	            													current,
            	            													"formula",
            	            													lv_formula_6_0,
            	            													"capone.CaponeDsl.Formula");
            	            												afterParserOrEnumRuleCall();
            	            											

            	            }


            	            }


            	            }
            	            break;

            	    }

            	    // InternalCaponeDsl.g:158:9: (otherlv_7= 'metamodel' ( (lv_metamodel_8_0= ruleEString ) ) )
            	    // InternalCaponeDsl.g:159:10: otherlv_7= 'metamodel' ( (lv_metamodel_8_0= ruleEString ) )
            	    {
            	    otherlv_7=(Token)match(input,15,FOLLOW_4); 

            	    										newLeafNode(otherlv_7, grammarAccess.getModuleAccess().getMetamodelKeyword_4_0_1_0());
            	    									
            	    // InternalCaponeDsl.g:163:10: ( (lv_metamodel_8_0= ruleEString ) )
            	    // InternalCaponeDsl.g:164:11: (lv_metamodel_8_0= ruleEString )
            	    {
            	    // InternalCaponeDsl.g:164:11: (lv_metamodel_8_0= ruleEString )
            	    // InternalCaponeDsl.g:165:12: lv_metamodel_8_0= ruleEString
            	    {

            	    												newCompositeNode(grammarAccess.getModuleAccess().getMetamodelEStringParserRuleCall_4_0_1_1_0());
            	    											
            	    pushFollow(FOLLOW_9);
            	    lv_metamodel_8_0=ruleEString();

            	    state._fsp--;


            	    												if (current==null) {
            	    													current = createModelElementForParent(grammarAccess.getModuleRule());
            	    												}
            	    												set(
            	    													current,
            	    													"metamodel",
            	    													lv_metamodel_8_0,
            	    													"capone.CaponeDsl.EString");
            	    												afterParserOrEnumRuleCall();
            	    											

            	    }


            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getModuleAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalCaponeDsl.g:189:4: ({...}? => ( ({...}? => (otherlv_9= 'extends.mandatory' ( ( ruleEString ) ) (otherlv_11= ',' ( ( ruleEString ) ) )* ) ) ) )
            	    {
            	    // InternalCaponeDsl.g:189:4: ({...}? => ( ({...}? => (otherlv_9= 'extends.mandatory' ( ( ruleEString ) ) (otherlv_11= ',' ( ( ruleEString ) ) )* ) ) ) )
            	    // InternalCaponeDsl.g:190:5: {...}? => ( ({...}? => (otherlv_9= 'extends.mandatory' ( ( ruleEString ) ) (otherlv_11= ',' ( ( ruleEString ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getModuleAccess().getUnorderedGroup_4(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleModule", "getUnorderedGroupHelper().canSelect(grammarAccess.getModuleAccess().getUnorderedGroup_4(), 1)");
            	    }
            	    // InternalCaponeDsl.g:190:103: ( ({...}? => (otherlv_9= 'extends.mandatory' ( ( ruleEString ) ) (otherlv_11= ',' ( ( ruleEString ) ) )* ) ) )
            	    // InternalCaponeDsl.g:191:6: ({...}? => (otherlv_9= 'extends.mandatory' ( ( ruleEString ) ) (otherlv_11= ',' ( ( ruleEString ) ) )* ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getModuleAccess().getUnorderedGroup_4(), 1);
            	    					
            	    // InternalCaponeDsl.g:194:9: ({...}? => (otherlv_9= 'extends.mandatory' ( ( ruleEString ) ) (otherlv_11= ',' ( ( ruleEString ) ) )* ) )
            	    // InternalCaponeDsl.g:194:10: {...}? => (otherlv_9= 'extends.mandatory' ( ( ruleEString ) ) (otherlv_11= ',' ( ( ruleEString ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleModule", "true");
            	    }
            	    // InternalCaponeDsl.g:194:19: (otherlv_9= 'extends.mandatory' ( ( ruleEString ) ) (otherlv_11= ',' ( ( ruleEString ) ) )* )
            	    // InternalCaponeDsl.g:194:20: otherlv_9= 'extends.mandatory' ( ( ruleEString ) ) (otherlv_11= ',' ( ( ruleEString ) ) )*
            	    {
            	    otherlv_9=(Token)match(input,16,FOLLOW_4); 

            	    									newLeafNode(otherlv_9, grammarAccess.getModuleAccess().getExtendsMandatoryKeyword_4_1_0());
            	    								
            	    // InternalCaponeDsl.g:198:9: ( ( ruleEString ) )
            	    // InternalCaponeDsl.g:199:10: ( ruleEString )
            	    {
            	    // InternalCaponeDsl.g:199:10: ( ruleEString )
            	    // InternalCaponeDsl.g:200:11: ruleEString
            	    {

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getModuleRule());
            	    											}
            	    										

            	    											newCompositeNode(grammarAccess.getModuleAccess().getModuleMandatoryModuleCrossReference_4_1_1_0());
            	    										
            	    pushFollow(FOLLOW_10);
            	    ruleEString();

            	    state._fsp--;


            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }

            	    // InternalCaponeDsl.g:214:9: (otherlv_11= ',' ( ( ruleEString ) ) )*
            	    loop3:
            	    do {
            	        int alt3=2;
            	        int LA3_0 = input.LA(1);

            	        if ( (LA3_0==17) ) {
            	            alt3=1;
            	        }


            	        switch (alt3) {
            	    	case 1 :
            	    	    // InternalCaponeDsl.g:215:10: otherlv_11= ',' ( ( ruleEString ) )
            	    	    {
            	    	    otherlv_11=(Token)match(input,17,FOLLOW_4); 

            	    	    										newLeafNode(otherlv_11, grammarAccess.getModuleAccess().getCommaKeyword_4_1_2_0());
            	    	    									
            	    	    // InternalCaponeDsl.g:219:10: ( ( ruleEString ) )
            	    	    // InternalCaponeDsl.g:220:11: ( ruleEString )
            	    	    {
            	    	    // InternalCaponeDsl.g:220:11: ( ruleEString )
            	    	    // InternalCaponeDsl.g:221:12: ruleEString
            	    	    {

            	    	    												if (current==null) {
            	    	    													current = createModelElement(grammarAccess.getModuleRule());
            	    	    												}
            	    	    											

            	    	    												newCompositeNode(grammarAccess.getModuleAccess().getModuleMandatoryModuleCrossReference_4_1_2_1_0());
            	    	    											
            	    	    pushFollow(FOLLOW_10);
            	    	    ruleEString();

            	    	    state._fsp--;


            	    	    												afterParserOrEnumRuleCall();
            	    	    											

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop3;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getModuleAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalCaponeDsl.g:242:4: ({...}? => ( ({...}? => (otherlv_13= 'extends.optional' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )* ) ) ) )
            	    {
            	    // InternalCaponeDsl.g:242:4: ({...}? => ( ({...}? => (otherlv_13= 'extends.optional' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )* ) ) ) )
            	    // InternalCaponeDsl.g:243:5: {...}? => ( ({...}? => (otherlv_13= 'extends.optional' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getModuleAccess().getUnorderedGroup_4(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleModule", "getUnorderedGroupHelper().canSelect(grammarAccess.getModuleAccess().getUnorderedGroup_4(), 2)");
            	    }
            	    // InternalCaponeDsl.g:243:103: ( ({...}? => (otherlv_13= 'extends.optional' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )* ) ) )
            	    // InternalCaponeDsl.g:244:6: ({...}? => (otherlv_13= 'extends.optional' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )* ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getModuleAccess().getUnorderedGroup_4(), 2);
            	    					
            	    // InternalCaponeDsl.g:247:9: ({...}? => (otherlv_13= 'extends.optional' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )* ) )
            	    // InternalCaponeDsl.g:247:10: {...}? => (otherlv_13= 'extends.optional' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleModule", "true");
            	    }
            	    // InternalCaponeDsl.g:247:19: (otherlv_13= 'extends.optional' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )* )
            	    // InternalCaponeDsl.g:247:20: otherlv_13= 'extends.optional' ( ( ruleEString ) ) (otherlv_15= ',' ( ( ruleEString ) ) )*
            	    {
            	    otherlv_13=(Token)match(input,18,FOLLOW_4); 

            	    									newLeafNode(otherlv_13, grammarAccess.getModuleAccess().getExtendsOptionalKeyword_4_2_0());
            	    								
            	    // InternalCaponeDsl.g:251:9: ( ( ruleEString ) )
            	    // InternalCaponeDsl.g:252:10: ( ruleEString )
            	    {
            	    // InternalCaponeDsl.g:252:10: ( ruleEString )
            	    // InternalCaponeDsl.g:253:11: ruleEString
            	    {

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getModuleRule());
            	    											}
            	    										

            	    											newCompositeNode(grammarAccess.getModuleAccess().getModuleOptionalModuleCrossReference_4_2_1_0());
            	    										
            	    pushFollow(FOLLOW_10);
            	    ruleEString();

            	    state._fsp--;


            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }

            	    // InternalCaponeDsl.g:267:9: (otherlv_15= ',' ( ( ruleEString ) ) )*
            	    loop4:
            	    do {
            	        int alt4=2;
            	        int LA4_0 = input.LA(1);

            	        if ( (LA4_0==17) ) {
            	            alt4=1;
            	        }


            	        switch (alt4) {
            	    	case 1 :
            	    	    // InternalCaponeDsl.g:268:10: otherlv_15= ',' ( ( ruleEString ) )
            	    	    {
            	    	    otherlv_15=(Token)match(input,17,FOLLOW_4); 

            	    	    										newLeafNode(otherlv_15, grammarAccess.getModuleAccess().getCommaKeyword_4_2_2_0());
            	    	    									
            	    	    // InternalCaponeDsl.g:272:10: ( ( ruleEString ) )
            	    	    // InternalCaponeDsl.g:273:11: ( ruleEString )
            	    	    {
            	    	    // InternalCaponeDsl.g:273:11: ( ruleEString )
            	    	    // InternalCaponeDsl.g:274:12: ruleEString
            	    	    {

            	    	    												if (current==null) {
            	    	    													current = createModelElement(grammarAccess.getModuleRule());
            	    	    												}
            	    	    											

            	    	    												newCompositeNode(grammarAccess.getModuleAccess().getModuleOptionalModuleCrossReference_4_2_2_1_0());
            	    	    											
            	    	    pushFollow(FOLLOW_10);
            	    	    ruleEString();

            	    	    state._fsp--;


            	    	    												afterParserOrEnumRuleCall();
            	    	    											

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop4;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getModuleAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalCaponeDsl.g:295:4: ({...}? => ( ({...}? => (otherlv_17= 'extends.alternative' ( ( ruleEString ) ) (otherlv_19= ',' ( ( ruleEString ) ) )* ) ) ) )
            	    {
            	    // InternalCaponeDsl.g:295:4: ({...}? => ( ({...}? => (otherlv_17= 'extends.alternative' ( ( ruleEString ) ) (otherlv_19= ',' ( ( ruleEString ) ) )* ) ) ) )
            	    // InternalCaponeDsl.g:296:5: {...}? => ( ({...}? => (otherlv_17= 'extends.alternative' ( ( ruleEString ) ) (otherlv_19= ',' ( ( ruleEString ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getModuleAccess().getUnorderedGroup_4(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleModule", "getUnorderedGroupHelper().canSelect(grammarAccess.getModuleAccess().getUnorderedGroup_4(), 3)");
            	    }
            	    // InternalCaponeDsl.g:296:103: ( ({...}? => (otherlv_17= 'extends.alternative' ( ( ruleEString ) ) (otherlv_19= ',' ( ( ruleEString ) ) )* ) ) )
            	    // InternalCaponeDsl.g:297:6: ({...}? => (otherlv_17= 'extends.alternative' ( ( ruleEString ) ) (otherlv_19= ',' ( ( ruleEString ) ) )* ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getModuleAccess().getUnorderedGroup_4(), 3);
            	    					
            	    // InternalCaponeDsl.g:300:9: ({...}? => (otherlv_17= 'extends.alternative' ( ( ruleEString ) ) (otherlv_19= ',' ( ( ruleEString ) ) )* ) )
            	    // InternalCaponeDsl.g:300:10: {...}? => (otherlv_17= 'extends.alternative' ( ( ruleEString ) ) (otherlv_19= ',' ( ( ruleEString ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleModule", "true");
            	    }
            	    // InternalCaponeDsl.g:300:19: (otherlv_17= 'extends.alternative' ( ( ruleEString ) ) (otherlv_19= ',' ( ( ruleEString ) ) )* )
            	    // InternalCaponeDsl.g:300:20: otherlv_17= 'extends.alternative' ( ( ruleEString ) ) (otherlv_19= ',' ( ( ruleEString ) ) )*
            	    {
            	    otherlv_17=(Token)match(input,19,FOLLOW_4); 

            	    									newLeafNode(otherlv_17, grammarAccess.getModuleAccess().getExtendsAlternativeKeyword_4_3_0());
            	    								
            	    // InternalCaponeDsl.g:304:9: ( ( ruleEString ) )
            	    // InternalCaponeDsl.g:305:10: ( ruleEString )
            	    {
            	    // InternalCaponeDsl.g:305:10: ( ruleEString )
            	    // InternalCaponeDsl.g:306:11: ruleEString
            	    {

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getModuleRule());
            	    											}
            	    										

            	    											newCompositeNode(grammarAccess.getModuleAccess().getModuleAlternativeModuleCrossReference_4_3_1_0());
            	    										
            	    pushFollow(FOLLOW_10);
            	    ruleEString();

            	    state._fsp--;


            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }

            	    // InternalCaponeDsl.g:320:9: (otherlv_19= ',' ( ( ruleEString ) ) )*
            	    loop5:
            	    do {
            	        int alt5=2;
            	        int LA5_0 = input.LA(1);

            	        if ( (LA5_0==17) ) {
            	            alt5=1;
            	        }


            	        switch (alt5) {
            	    	case 1 :
            	    	    // InternalCaponeDsl.g:321:10: otherlv_19= ',' ( ( ruleEString ) )
            	    	    {
            	    	    otherlv_19=(Token)match(input,17,FOLLOW_4); 

            	    	    										newLeafNode(otherlv_19, grammarAccess.getModuleAccess().getCommaKeyword_4_3_2_0());
            	    	    									
            	    	    // InternalCaponeDsl.g:325:10: ( ( ruleEString ) )
            	    	    // InternalCaponeDsl.g:326:11: ( ruleEString )
            	    	    {
            	    	    // InternalCaponeDsl.g:326:11: ( ruleEString )
            	    	    // InternalCaponeDsl.g:327:12: ruleEString
            	    	    {

            	    	    												if (current==null) {
            	    	    													current = createModelElement(grammarAccess.getModuleRule());
            	    	    												}
            	    	    											

            	    	    												newCompositeNode(grammarAccess.getModuleAccess().getModuleAlternativeModuleCrossReference_4_3_2_1_0());
            	    	    											
            	    	    pushFollow(FOLLOW_10);
            	    	    ruleEString();

            	    	    state._fsp--;


            	    	    												afterParserOrEnumRuleCall();
            	    	    											

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop5;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getModuleAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalCaponeDsl.g:348:4: ({...}? => ( ({...}? => (otherlv_21= 'extends.or' ( ( ruleEString ) ) (otherlv_23= ',' ( ( ruleEString ) ) )* ) ) ) )
            	    {
            	    // InternalCaponeDsl.g:348:4: ({...}? => ( ({...}? => (otherlv_21= 'extends.or' ( ( ruleEString ) ) (otherlv_23= ',' ( ( ruleEString ) ) )* ) ) ) )
            	    // InternalCaponeDsl.g:349:5: {...}? => ( ({...}? => (otherlv_21= 'extends.or' ( ( ruleEString ) ) (otherlv_23= ',' ( ( ruleEString ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getModuleAccess().getUnorderedGroup_4(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleModule", "getUnorderedGroupHelper().canSelect(grammarAccess.getModuleAccess().getUnorderedGroup_4(), 4)");
            	    }
            	    // InternalCaponeDsl.g:349:103: ( ({...}? => (otherlv_21= 'extends.or' ( ( ruleEString ) ) (otherlv_23= ',' ( ( ruleEString ) ) )* ) ) )
            	    // InternalCaponeDsl.g:350:6: ({...}? => (otherlv_21= 'extends.or' ( ( ruleEString ) ) (otherlv_23= ',' ( ( ruleEString ) ) )* ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getModuleAccess().getUnorderedGroup_4(), 4);
            	    					
            	    // InternalCaponeDsl.g:353:9: ({...}? => (otherlv_21= 'extends.or' ( ( ruleEString ) ) (otherlv_23= ',' ( ( ruleEString ) ) )* ) )
            	    // InternalCaponeDsl.g:353:10: {...}? => (otherlv_21= 'extends.or' ( ( ruleEString ) ) (otherlv_23= ',' ( ( ruleEString ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleModule", "true");
            	    }
            	    // InternalCaponeDsl.g:353:19: (otherlv_21= 'extends.or' ( ( ruleEString ) ) (otherlv_23= ',' ( ( ruleEString ) ) )* )
            	    // InternalCaponeDsl.g:353:20: otherlv_21= 'extends.or' ( ( ruleEString ) ) (otherlv_23= ',' ( ( ruleEString ) ) )*
            	    {
            	    otherlv_21=(Token)match(input,20,FOLLOW_4); 

            	    									newLeafNode(otherlv_21, grammarAccess.getModuleAccess().getExtendsOrKeyword_4_4_0());
            	    								
            	    // InternalCaponeDsl.g:357:9: ( ( ruleEString ) )
            	    // InternalCaponeDsl.g:358:10: ( ruleEString )
            	    {
            	    // InternalCaponeDsl.g:358:10: ( ruleEString )
            	    // InternalCaponeDsl.g:359:11: ruleEString
            	    {

            	    											if (current==null) {
            	    												current = createModelElement(grammarAccess.getModuleRule());
            	    											}
            	    										

            	    											newCompositeNode(grammarAccess.getModuleAccess().getModuleOrModuleCrossReference_4_4_1_0());
            	    										
            	    pushFollow(FOLLOW_10);
            	    ruleEString();

            	    state._fsp--;


            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }

            	    // InternalCaponeDsl.g:373:9: (otherlv_23= ',' ( ( ruleEString ) ) )*
            	    loop6:
            	    do {
            	        int alt6=2;
            	        int LA6_0 = input.LA(1);

            	        if ( (LA6_0==17) ) {
            	            alt6=1;
            	        }


            	        switch (alt6) {
            	    	case 1 :
            	    	    // InternalCaponeDsl.g:374:10: otherlv_23= ',' ( ( ruleEString ) )
            	    	    {
            	    	    otherlv_23=(Token)match(input,17,FOLLOW_4); 

            	    	    										newLeafNode(otherlv_23, grammarAccess.getModuleAccess().getCommaKeyword_4_4_2_0());
            	    	    									
            	    	    // InternalCaponeDsl.g:378:10: ( ( ruleEString ) )
            	    	    // InternalCaponeDsl.g:379:11: ( ruleEString )
            	    	    {
            	    	    // InternalCaponeDsl.g:379:11: ( ruleEString )
            	    	    // InternalCaponeDsl.g:380:12: ruleEString
            	    	    {

            	    	    												if (current==null) {
            	    	    													current = createModelElement(grammarAccess.getModuleRule());
            	    	    												}
            	    	    											

            	    	    												newCompositeNode(grammarAccess.getModuleAccess().getModuleOrModuleCrossReference_4_4_2_1_0());
            	    	    											
            	    	    pushFollow(FOLLOW_10);
            	    	    ruleEString();

            	    	    state._fsp--;


            	    	    												afterParserOrEnumRuleCall();
            	    	    											

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop6;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getModuleAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalCaponeDsl.g:401:4: ({...}? => ( ({...}? => (otherlv_25= 'rules' ( (lv_rules_26_0= ruleRuleSet ) ) ) ) ) )
            	    {
            	    // InternalCaponeDsl.g:401:4: ({...}? => ( ({...}? => (otherlv_25= 'rules' ( (lv_rules_26_0= ruleRuleSet ) ) ) ) ) )
            	    // InternalCaponeDsl.g:402:5: {...}? => ( ({...}? => (otherlv_25= 'rules' ( (lv_rules_26_0= ruleRuleSet ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getModuleAccess().getUnorderedGroup_4(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleModule", "getUnorderedGroupHelper().canSelect(grammarAccess.getModuleAccess().getUnorderedGroup_4(), 5)");
            	    }
            	    // InternalCaponeDsl.g:402:103: ( ({...}? => (otherlv_25= 'rules' ( (lv_rules_26_0= ruleRuleSet ) ) ) ) )
            	    // InternalCaponeDsl.g:403:6: ({...}? => (otherlv_25= 'rules' ( (lv_rules_26_0= ruleRuleSet ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getModuleAccess().getUnorderedGroup_4(), 5);
            	    					
            	    // InternalCaponeDsl.g:406:9: ({...}? => (otherlv_25= 'rules' ( (lv_rules_26_0= ruleRuleSet ) ) ) )
            	    // InternalCaponeDsl.g:406:10: {...}? => (otherlv_25= 'rules' ( (lv_rules_26_0= ruleRuleSet ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleModule", "true");
            	    }
            	    // InternalCaponeDsl.g:406:19: (otherlv_25= 'rules' ( (lv_rules_26_0= ruleRuleSet ) ) )
            	    // InternalCaponeDsl.g:406:20: otherlv_25= 'rules' ( (lv_rules_26_0= ruleRuleSet ) )
            	    {
            	    otherlv_25=(Token)match(input,21,FOLLOW_4); 

            	    									newLeafNode(otherlv_25, grammarAccess.getModuleAccess().getRulesKeyword_4_5_0());
            	    								
            	    // InternalCaponeDsl.g:410:9: ( (lv_rules_26_0= ruleRuleSet ) )
            	    // InternalCaponeDsl.g:411:10: (lv_rules_26_0= ruleRuleSet )
            	    {
            	    // InternalCaponeDsl.g:411:10: (lv_rules_26_0= ruleRuleSet )
            	    // InternalCaponeDsl.g:412:11: lv_rules_26_0= ruleRuleSet
            	    {

            	    											newCompositeNode(grammarAccess.getModuleAccess().getRulesRuleSetParserRuleCall_4_5_1_0());
            	    										
            	    pushFollow(FOLLOW_9);
            	    lv_rules_26_0=ruleRuleSet();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getModuleRule());
            	    											}
            	    											set(
            	    												current,
            	    												"rules",
            	    												lv_rules_26_0,
            	    												"capone.CaponeDsl.RuleSet");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getModuleAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // InternalCaponeDsl.g:435:4: ({...}? => ( ({...}? => (otherlv_27= 'diagram' ( (lv_chooseDiagram_28_0= ruleDiagram ) ) ) ) ) )
            	    {
            	    // InternalCaponeDsl.g:435:4: ({...}? => ( ({...}? => (otherlv_27= 'diagram' ( (lv_chooseDiagram_28_0= ruleDiagram ) ) ) ) ) )
            	    // InternalCaponeDsl.g:436:5: {...}? => ( ({...}? => (otherlv_27= 'diagram' ( (lv_chooseDiagram_28_0= ruleDiagram ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getModuleAccess().getUnorderedGroup_4(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleModule", "getUnorderedGroupHelper().canSelect(grammarAccess.getModuleAccess().getUnorderedGroup_4(), 6)");
            	    }
            	    // InternalCaponeDsl.g:436:103: ( ({...}? => (otherlv_27= 'diagram' ( (lv_chooseDiagram_28_0= ruleDiagram ) ) ) ) )
            	    // InternalCaponeDsl.g:437:6: ({...}? => (otherlv_27= 'diagram' ( (lv_chooseDiagram_28_0= ruleDiagram ) ) ) )
            	    {

            	    						getUnorderedGroupHelper().select(grammarAccess.getModuleAccess().getUnorderedGroup_4(), 6);
            	    					
            	    // InternalCaponeDsl.g:440:9: ({...}? => (otherlv_27= 'diagram' ( (lv_chooseDiagram_28_0= ruleDiagram ) ) ) )
            	    // InternalCaponeDsl.g:440:10: {...}? => (otherlv_27= 'diagram' ( (lv_chooseDiagram_28_0= ruleDiagram ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleModule", "true");
            	    }
            	    // InternalCaponeDsl.g:440:19: (otherlv_27= 'diagram' ( (lv_chooseDiagram_28_0= ruleDiagram ) ) )
            	    // InternalCaponeDsl.g:440:20: otherlv_27= 'diagram' ( (lv_chooseDiagram_28_0= ruleDiagram ) )
            	    {
            	    otherlv_27=(Token)match(input,22,FOLLOW_4); 

            	    									newLeafNode(otherlv_27, grammarAccess.getModuleAccess().getDiagramKeyword_4_6_0());
            	    								
            	    // InternalCaponeDsl.g:444:9: ( (lv_chooseDiagram_28_0= ruleDiagram ) )
            	    // InternalCaponeDsl.g:445:10: (lv_chooseDiagram_28_0= ruleDiagram )
            	    {
            	    // InternalCaponeDsl.g:445:10: (lv_chooseDiagram_28_0= ruleDiagram )
            	    // InternalCaponeDsl.g:446:11: lv_chooseDiagram_28_0= ruleDiagram
            	    {

            	    											newCompositeNode(grammarAccess.getModuleAccess().getChooseDiagramDiagramParserRuleCall_4_6_1_0());
            	    										
            	    pushFollow(FOLLOW_9);
            	    lv_chooseDiagram_28_0=ruleDiagram();

            	    state._fsp--;


            	    											if (current==null) {
            	    												current = createModelElementForParent(grammarAccess.getModuleRule());
            	    											}
            	    											set(
            	    												current,
            	    												"chooseDiagram",
            	    												lv_chooseDiagram_28_0,
            	    												"capone.CaponeDsl.Diagram");
            	    											afterParserOrEnumRuleCall();
            	    										

            	    }


            	    }


            	    }


            	    }

            	     
            	    						getUnorderedGroupHelper().returnFromSelection(grammarAccess.getModuleAccess().getUnorderedGroup_4());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getModuleAccess().getUnorderedGroup_4()) ) {
                throw new FailedPredicateException(input, "ruleModule", "getUnorderedGroupHelper().canLeave(grammarAccess.getModuleAccess().getUnorderedGroup_4())");
            }

            }


            }

             
            				  getUnorderedGroupHelper().leave(grammarAccess.getModuleAccess().getUnorderedGroup_4());
            				

            }

            otherlv_29=(Token)match(input,23,FOLLOW_2); 

            			newLeafNode(otherlv_29, grammarAccess.getModuleAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModule"


    // $ANTLR start "entryRuleEString"
    // InternalCaponeDsl.g:485:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalCaponeDsl.g:485:47: (iv_ruleEString= ruleEString EOF )
            // InternalCaponeDsl.g:486:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalCaponeDsl.g:492:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalCaponeDsl.g:498:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalCaponeDsl.g:499:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalCaponeDsl.g:499:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_STRING) ) {
                alt8=1;
            }
            else if ( (LA8_0==RULE_ID) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalCaponeDsl.g:500:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalCaponeDsl.g:508:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_1);
                    		

                    			newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleRuleSet"
    // InternalCaponeDsl.g:519:1: entryRuleRuleSet returns [EObject current=null] : iv_ruleRuleSet= ruleRuleSet EOF ;
    public final EObject entryRuleRuleSet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleSet = null;


        try {
            // InternalCaponeDsl.g:519:48: (iv_ruleRuleSet= ruleRuleSet EOF )
            // InternalCaponeDsl.g:520:2: iv_ruleRuleSet= ruleRuleSet EOF
            {
             newCompositeNode(grammarAccess.getRuleSetRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRuleSet=ruleRuleSet();

            state._fsp--;

             current =iv_ruleRuleSet; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRuleSet"


    // $ANTLR start "ruleRuleSet"
    // InternalCaponeDsl.g:526:1: ruleRuleSet returns [EObject current=null] : ( ( (lv_rulefile_0_0= ruleEString ) ) otherlv_1= '{' ( ( (lv_rules_2_0= ruleRule ) ) (otherlv_3= ',' ( (lv_rules_4_0= ruleRule ) ) )* )? otherlv_5= '}' ) ;
    public final EObject ruleRuleSet() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_rulefile_0_0 = null;

        EObject lv_rules_2_0 = null;

        EObject lv_rules_4_0 = null;



        	enterRule();

        try {
            // InternalCaponeDsl.g:532:2: ( ( ( (lv_rulefile_0_0= ruleEString ) ) otherlv_1= '{' ( ( (lv_rules_2_0= ruleRule ) ) (otherlv_3= ',' ( (lv_rules_4_0= ruleRule ) ) )* )? otherlv_5= '}' ) )
            // InternalCaponeDsl.g:533:2: ( ( (lv_rulefile_0_0= ruleEString ) ) otherlv_1= '{' ( ( (lv_rules_2_0= ruleRule ) ) (otherlv_3= ',' ( (lv_rules_4_0= ruleRule ) ) )* )? otherlv_5= '}' )
            {
            // InternalCaponeDsl.g:533:2: ( ( (lv_rulefile_0_0= ruleEString ) ) otherlv_1= '{' ( ( (lv_rules_2_0= ruleRule ) ) (otherlv_3= ',' ( (lv_rules_4_0= ruleRule ) ) )* )? otherlv_5= '}' )
            // InternalCaponeDsl.g:534:3: ( (lv_rulefile_0_0= ruleEString ) ) otherlv_1= '{' ( ( (lv_rules_2_0= ruleRule ) ) (otherlv_3= ',' ( (lv_rules_4_0= ruleRule ) ) )* )? otherlv_5= '}'
            {
            // InternalCaponeDsl.g:534:3: ( (lv_rulefile_0_0= ruleEString ) )
            // InternalCaponeDsl.g:535:4: (lv_rulefile_0_0= ruleEString )
            {
            // InternalCaponeDsl.g:535:4: (lv_rulefile_0_0= ruleEString )
            // InternalCaponeDsl.g:536:5: lv_rulefile_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getRuleSetAccess().getRulefileEStringParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_5);
            lv_rulefile_0_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRuleSetRule());
            					}
            					set(
            						current,
            						"rulefile",
            						lv_rulefile_0_0,
            						"capone.CaponeDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,13,FOLLOW_11); 

            			newLeafNode(otherlv_1, grammarAccess.getRuleSetAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalCaponeDsl.g:557:3: ( ( (lv_rules_2_0= ruleRule ) ) (otherlv_3= ',' ( (lv_rules_4_0= ruleRule ) ) )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0>=RULE_STRING && LA10_0<=RULE_ID)) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalCaponeDsl.g:558:4: ( (lv_rules_2_0= ruleRule ) ) (otherlv_3= ',' ( (lv_rules_4_0= ruleRule ) ) )*
                    {
                    // InternalCaponeDsl.g:558:4: ( (lv_rules_2_0= ruleRule ) )
                    // InternalCaponeDsl.g:559:5: (lv_rules_2_0= ruleRule )
                    {
                    // InternalCaponeDsl.g:559:5: (lv_rules_2_0= ruleRule )
                    // InternalCaponeDsl.g:560:6: lv_rules_2_0= ruleRule
                    {

                    						newCompositeNode(grammarAccess.getRuleSetAccess().getRulesRuleParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_12);
                    lv_rules_2_0=ruleRule();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRuleSetRule());
                    						}
                    						add(
                    							current,
                    							"rules",
                    							lv_rules_2_0,
                    							"capone.CaponeDsl.Rule");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalCaponeDsl.g:577:4: (otherlv_3= ',' ( (lv_rules_4_0= ruleRule ) ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==17) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalCaponeDsl.g:578:5: otherlv_3= ',' ( (lv_rules_4_0= ruleRule ) )
                    	    {
                    	    otherlv_3=(Token)match(input,17,FOLLOW_4); 

                    	    					newLeafNode(otherlv_3, grammarAccess.getRuleSetAccess().getCommaKeyword_2_1_0());
                    	    				
                    	    // InternalCaponeDsl.g:582:5: ( (lv_rules_4_0= ruleRule ) )
                    	    // InternalCaponeDsl.g:583:6: (lv_rules_4_0= ruleRule )
                    	    {
                    	    // InternalCaponeDsl.g:583:6: (lv_rules_4_0= ruleRule )
                    	    // InternalCaponeDsl.g:584:7: lv_rules_4_0= ruleRule
                    	    {

                    	    							newCompositeNode(grammarAccess.getRuleSetAccess().getRulesRuleParserRuleCall_2_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_12);
                    	    lv_rules_4_0=ruleRule();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getRuleSetRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"rules",
                    	    								lv_rules_4_0,
                    	    								"capone.CaponeDsl.Rule");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,23,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getRuleSetAccess().getRightCurlyBracketKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRuleSet"


    // $ANTLR start "entryRuleDiagram"
    // InternalCaponeDsl.g:611:1: entryRuleDiagram returns [EObject current=null] : iv_ruleDiagram= ruleDiagram EOF ;
    public final EObject entryRuleDiagram() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDiagram = null;


        try {
            // InternalCaponeDsl.g:611:48: (iv_ruleDiagram= ruleDiagram EOF )
            // InternalCaponeDsl.g:612:2: iv_ruleDiagram= ruleDiagram EOF
            {
             newCompositeNode(grammarAccess.getDiagramRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDiagram=ruleDiagram();

            state._fsp--;

             current =iv_ruleDiagram; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDiagram"


    // $ANTLR start "ruleDiagram"
    // InternalCaponeDsl.g:618:1: ruleDiagram returns [EObject current=null] : ( ( (lv_viewpointFileURI_0_0= ruleEString ) ) (otherlv_1= '{' (otherlv_2= 'override' ( (lv_overridesElements_3_0= ruleElement ) ) (otherlv_4= ',' ( (lv_overridesElements_5_0= ruleElement ) ) )* )? (otherlv_6= 'merge' ( (lv_merge_7_0= ruleElement ) ) (otherlv_8= ',' ( (lv_merge_9_0= ruleElement ) ) )* )? otherlv_10= '}' )? ) ;
    public final EObject ruleDiagram() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_viewpointFileURI_0_0 = null;

        EObject lv_overridesElements_3_0 = null;

        EObject lv_overridesElements_5_0 = null;

        EObject lv_merge_7_0 = null;

        EObject lv_merge_9_0 = null;



        	enterRule();

        try {
            // InternalCaponeDsl.g:624:2: ( ( ( (lv_viewpointFileURI_0_0= ruleEString ) ) (otherlv_1= '{' (otherlv_2= 'override' ( (lv_overridesElements_3_0= ruleElement ) ) (otherlv_4= ',' ( (lv_overridesElements_5_0= ruleElement ) ) )* )? (otherlv_6= 'merge' ( (lv_merge_7_0= ruleElement ) ) (otherlv_8= ',' ( (lv_merge_9_0= ruleElement ) ) )* )? otherlv_10= '}' )? ) )
            // InternalCaponeDsl.g:625:2: ( ( (lv_viewpointFileURI_0_0= ruleEString ) ) (otherlv_1= '{' (otherlv_2= 'override' ( (lv_overridesElements_3_0= ruleElement ) ) (otherlv_4= ',' ( (lv_overridesElements_5_0= ruleElement ) ) )* )? (otherlv_6= 'merge' ( (lv_merge_7_0= ruleElement ) ) (otherlv_8= ',' ( (lv_merge_9_0= ruleElement ) ) )* )? otherlv_10= '}' )? )
            {
            // InternalCaponeDsl.g:625:2: ( ( (lv_viewpointFileURI_0_0= ruleEString ) ) (otherlv_1= '{' (otherlv_2= 'override' ( (lv_overridesElements_3_0= ruleElement ) ) (otherlv_4= ',' ( (lv_overridesElements_5_0= ruleElement ) ) )* )? (otherlv_6= 'merge' ( (lv_merge_7_0= ruleElement ) ) (otherlv_8= ',' ( (lv_merge_9_0= ruleElement ) ) )* )? otherlv_10= '}' )? )
            // InternalCaponeDsl.g:626:3: ( (lv_viewpointFileURI_0_0= ruleEString ) ) (otherlv_1= '{' (otherlv_2= 'override' ( (lv_overridesElements_3_0= ruleElement ) ) (otherlv_4= ',' ( (lv_overridesElements_5_0= ruleElement ) ) )* )? (otherlv_6= 'merge' ( (lv_merge_7_0= ruleElement ) ) (otherlv_8= ',' ( (lv_merge_9_0= ruleElement ) ) )* )? otherlv_10= '}' )?
            {
            // InternalCaponeDsl.g:626:3: ( (lv_viewpointFileURI_0_0= ruleEString ) )
            // InternalCaponeDsl.g:627:4: (lv_viewpointFileURI_0_0= ruleEString )
            {
            // InternalCaponeDsl.g:627:4: (lv_viewpointFileURI_0_0= ruleEString )
            // InternalCaponeDsl.g:628:5: lv_viewpointFileURI_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getDiagramAccess().getViewpointFileURIEStringParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_13);
            lv_viewpointFileURI_0_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDiagramRule());
            					}
            					set(
            						current,
            						"viewpointFileURI",
            						lv_viewpointFileURI_0_0,
            						"capone.CaponeDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalCaponeDsl.g:645:3: (otherlv_1= '{' (otherlv_2= 'override' ( (lv_overridesElements_3_0= ruleElement ) ) (otherlv_4= ',' ( (lv_overridesElements_5_0= ruleElement ) ) )* )? (otherlv_6= 'merge' ( (lv_merge_7_0= ruleElement ) ) (otherlv_8= ',' ( (lv_merge_9_0= ruleElement ) ) )* )? otherlv_10= '}' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==13) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalCaponeDsl.g:646:4: otherlv_1= '{' (otherlv_2= 'override' ( (lv_overridesElements_3_0= ruleElement ) ) (otherlv_4= ',' ( (lv_overridesElements_5_0= ruleElement ) ) )* )? (otherlv_6= 'merge' ( (lv_merge_7_0= ruleElement ) ) (otherlv_8= ',' ( (lv_merge_9_0= ruleElement ) ) )* )? otherlv_10= '}'
                    {
                    otherlv_1=(Token)match(input,13,FOLLOW_14); 

                    				newLeafNode(otherlv_1, grammarAccess.getDiagramAccess().getLeftCurlyBracketKeyword_1_0());
                    			
                    // InternalCaponeDsl.g:650:4: (otherlv_2= 'override' ( (lv_overridesElements_3_0= ruleElement ) ) (otherlv_4= ',' ( (lv_overridesElements_5_0= ruleElement ) ) )* )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==24) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // InternalCaponeDsl.g:651:5: otherlv_2= 'override' ( (lv_overridesElements_3_0= ruleElement ) ) (otherlv_4= ',' ( (lv_overridesElements_5_0= ruleElement ) ) )*
                            {
                            otherlv_2=(Token)match(input,24,FOLLOW_4); 

                            					newLeafNode(otherlv_2, grammarAccess.getDiagramAccess().getOverrideKeyword_1_1_0());
                            				
                            // InternalCaponeDsl.g:655:5: ( (lv_overridesElements_3_0= ruleElement ) )
                            // InternalCaponeDsl.g:656:6: (lv_overridesElements_3_0= ruleElement )
                            {
                            // InternalCaponeDsl.g:656:6: (lv_overridesElements_3_0= ruleElement )
                            // InternalCaponeDsl.g:657:7: lv_overridesElements_3_0= ruleElement
                            {

                            							newCompositeNode(grammarAccess.getDiagramAccess().getOverridesElementsElementParserRuleCall_1_1_1_0());
                            						
                            pushFollow(FOLLOW_15);
                            lv_overridesElements_3_0=ruleElement();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getDiagramRule());
                            							}
                            							add(
                            								current,
                            								"overridesElements",
                            								lv_overridesElements_3_0,
                            								"capone.CaponeDsl.Element");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            // InternalCaponeDsl.g:674:5: (otherlv_4= ',' ( (lv_overridesElements_5_0= ruleElement ) ) )*
                            loop11:
                            do {
                                int alt11=2;
                                int LA11_0 = input.LA(1);

                                if ( (LA11_0==17) ) {
                                    alt11=1;
                                }


                                switch (alt11) {
                            	case 1 :
                            	    // InternalCaponeDsl.g:675:6: otherlv_4= ',' ( (lv_overridesElements_5_0= ruleElement ) )
                            	    {
                            	    otherlv_4=(Token)match(input,17,FOLLOW_4); 

                            	    						newLeafNode(otherlv_4, grammarAccess.getDiagramAccess().getCommaKeyword_1_1_2_0());
                            	    					
                            	    // InternalCaponeDsl.g:679:6: ( (lv_overridesElements_5_0= ruleElement ) )
                            	    // InternalCaponeDsl.g:680:7: (lv_overridesElements_5_0= ruleElement )
                            	    {
                            	    // InternalCaponeDsl.g:680:7: (lv_overridesElements_5_0= ruleElement )
                            	    // InternalCaponeDsl.g:681:8: lv_overridesElements_5_0= ruleElement
                            	    {

                            	    								newCompositeNode(grammarAccess.getDiagramAccess().getOverridesElementsElementParserRuleCall_1_1_2_1_0());
                            	    							
                            	    pushFollow(FOLLOW_15);
                            	    lv_overridesElements_5_0=ruleElement();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getDiagramRule());
                            	    								}
                            	    								add(
                            	    									current,
                            	    									"overridesElements",
                            	    									lv_overridesElements_5_0,
                            	    									"capone.CaponeDsl.Element");
                            	    								afterParserOrEnumRuleCall();
                            	    							

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop11;
                                }
                            } while (true);


                            }
                            break;

                    }

                    // InternalCaponeDsl.g:700:4: (otherlv_6= 'merge' ( (lv_merge_7_0= ruleElement ) ) (otherlv_8= ',' ( (lv_merge_9_0= ruleElement ) ) )* )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==25) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // InternalCaponeDsl.g:701:5: otherlv_6= 'merge' ( (lv_merge_7_0= ruleElement ) ) (otherlv_8= ',' ( (lv_merge_9_0= ruleElement ) ) )*
                            {
                            otherlv_6=(Token)match(input,25,FOLLOW_4); 

                            					newLeafNode(otherlv_6, grammarAccess.getDiagramAccess().getMergeKeyword_1_2_0());
                            				
                            // InternalCaponeDsl.g:705:5: ( (lv_merge_7_0= ruleElement ) )
                            // InternalCaponeDsl.g:706:6: (lv_merge_7_0= ruleElement )
                            {
                            // InternalCaponeDsl.g:706:6: (lv_merge_7_0= ruleElement )
                            // InternalCaponeDsl.g:707:7: lv_merge_7_0= ruleElement
                            {

                            							newCompositeNode(grammarAccess.getDiagramAccess().getMergeElementParserRuleCall_1_2_1_0());
                            						
                            pushFollow(FOLLOW_12);
                            lv_merge_7_0=ruleElement();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getDiagramRule());
                            							}
                            							add(
                            								current,
                            								"merge",
                            								lv_merge_7_0,
                            								"capone.CaponeDsl.Element");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            // InternalCaponeDsl.g:724:5: (otherlv_8= ',' ( (lv_merge_9_0= ruleElement ) ) )*
                            loop13:
                            do {
                                int alt13=2;
                                int LA13_0 = input.LA(1);

                                if ( (LA13_0==17) ) {
                                    alt13=1;
                                }


                                switch (alt13) {
                            	case 1 :
                            	    // InternalCaponeDsl.g:725:6: otherlv_8= ',' ( (lv_merge_9_0= ruleElement ) )
                            	    {
                            	    otherlv_8=(Token)match(input,17,FOLLOW_4); 

                            	    						newLeafNode(otherlv_8, grammarAccess.getDiagramAccess().getCommaKeyword_1_2_2_0());
                            	    					
                            	    // InternalCaponeDsl.g:729:6: ( (lv_merge_9_0= ruleElement ) )
                            	    // InternalCaponeDsl.g:730:7: (lv_merge_9_0= ruleElement )
                            	    {
                            	    // InternalCaponeDsl.g:730:7: (lv_merge_9_0= ruleElement )
                            	    // InternalCaponeDsl.g:731:8: lv_merge_9_0= ruleElement
                            	    {

                            	    								newCompositeNode(grammarAccess.getDiagramAccess().getMergeElementParserRuleCall_1_2_2_1_0());
                            	    							
                            	    pushFollow(FOLLOW_12);
                            	    lv_merge_9_0=ruleElement();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getDiagramRule());
                            	    								}
                            	    								add(
                            	    									current,
                            	    									"merge",
                            	    									lv_merge_9_0,
                            	    									"capone.CaponeDsl.Element");
                            	    								afterParserOrEnumRuleCall();
                            	    							

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop13;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_10=(Token)match(input,23,FOLLOW_2); 

                    				newLeafNode(otherlv_10, grammarAccess.getDiagramAccess().getRightCurlyBracketKeyword_1_3());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDiagram"


    // $ANTLR start "entryRuleElement"
    // InternalCaponeDsl.g:759:1: entryRuleElement returns [EObject current=null] : iv_ruleElement= ruleElement EOF ;
    public final EObject entryRuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElement = null;


        try {
            // InternalCaponeDsl.g:759:48: (iv_ruleElement= ruleElement EOF )
            // InternalCaponeDsl.g:760:2: iv_ruleElement= ruleElement EOF
            {
             newCompositeNode(grammarAccess.getElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleElement=ruleElement();

            state._fsp--;

             current =iv_ruleElement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // InternalCaponeDsl.g:766:1: ruleElement returns [EObject current=null] : ( ( (lv_elementId_0_0= ruleEString ) ) ( (lv_feature_1_0= ruleFeatureElement ) )? (otherlv_2= '(' ( ( ruleEString ) ) (otherlv_4= ',' ( ( ruleEString ) ) )* otherlv_6= ')' )? ) ;
    public final EObject ruleElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_elementId_0_0 = null;

        EObject lv_feature_1_0 = null;



        	enterRule();

        try {
            // InternalCaponeDsl.g:772:2: ( ( ( (lv_elementId_0_0= ruleEString ) ) ( (lv_feature_1_0= ruleFeatureElement ) )? (otherlv_2= '(' ( ( ruleEString ) ) (otherlv_4= ',' ( ( ruleEString ) ) )* otherlv_6= ')' )? ) )
            // InternalCaponeDsl.g:773:2: ( ( (lv_elementId_0_0= ruleEString ) ) ( (lv_feature_1_0= ruleFeatureElement ) )? (otherlv_2= '(' ( ( ruleEString ) ) (otherlv_4= ',' ( ( ruleEString ) ) )* otherlv_6= ')' )? )
            {
            // InternalCaponeDsl.g:773:2: ( ( (lv_elementId_0_0= ruleEString ) ) ( (lv_feature_1_0= ruleFeatureElement ) )? (otherlv_2= '(' ( ( ruleEString ) ) (otherlv_4= ',' ( ( ruleEString ) ) )* otherlv_6= ')' )? )
            // InternalCaponeDsl.g:774:3: ( (lv_elementId_0_0= ruleEString ) ) ( (lv_feature_1_0= ruleFeatureElement ) )? (otherlv_2= '(' ( ( ruleEString ) ) (otherlv_4= ',' ( ( ruleEString ) ) )* otherlv_6= ')' )?
            {
            // InternalCaponeDsl.g:774:3: ( (lv_elementId_0_0= ruleEString ) )
            // InternalCaponeDsl.g:775:4: (lv_elementId_0_0= ruleEString )
            {
            // InternalCaponeDsl.g:775:4: (lv_elementId_0_0= ruleEString )
            // InternalCaponeDsl.g:776:5: lv_elementId_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getElementAccess().getElementIdEStringParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_16);
            lv_elementId_0_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getElementRule());
            					}
            					set(
            						current,
            						"elementId",
            						lv_elementId_0_0,
            						"capone.CaponeDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalCaponeDsl.g:793:3: ( (lv_feature_1_0= ruleFeatureElement ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==28) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalCaponeDsl.g:794:4: (lv_feature_1_0= ruleFeatureElement )
                    {
                    // InternalCaponeDsl.g:794:4: (lv_feature_1_0= ruleFeatureElement )
                    // InternalCaponeDsl.g:795:5: lv_feature_1_0= ruleFeatureElement
                    {

                    					newCompositeNode(grammarAccess.getElementAccess().getFeatureFeatureElementParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_17);
                    lv_feature_1_0=ruleFeatureElement();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getElementRule());
                    					}
                    					set(
                    						current,
                    						"feature",
                    						lv_feature_1_0,
                    						"capone.CaponeDsl.FeatureElement");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalCaponeDsl.g:812:3: (otherlv_2= '(' ( ( ruleEString ) ) (otherlv_4= ',' ( ( ruleEString ) ) )* otherlv_6= ')' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==26) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalCaponeDsl.g:813:4: otherlv_2= '(' ( ( ruleEString ) ) (otherlv_4= ',' ( ( ruleEString ) ) )* otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,26,FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getElementAccess().getLeftParenthesisKeyword_2_0());
                    			
                    // InternalCaponeDsl.g:817:4: ( ( ruleEString ) )
                    // InternalCaponeDsl.g:818:5: ( ruleEString )
                    {
                    // InternalCaponeDsl.g:818:5: ( ruleEString )
                    // InternalCaponeDsl.g:819:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getElementRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getElementAccess().getOverModulesModuleCrossReference_2_1_0());
                    					
                    pushFollow(FOLLOW_18);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalCaponeDsl.g:833:4: (otherlv_4= ',' ( ( ruleEString ) ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==17) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // InternalCaponeDsl.g:834:5: otherlv_4= ',' ( ( ruleEString ) )
                    	    {
                    	    otherlv_4=(Token)match(input,17,FOLLOW_4); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getElementAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalCaponeDsl.g:838:5: ( ( ruleEString ) )
                    	    // InternalCaponeDsl.g:839:6: ( ruleEString )
                    	    {
                    	    // InternalCaponeDsl.g:839:6: ( ruleEString )
                    	    // InternalCaponeDsl.g:840:7: ruleEString
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getElementRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getElementAccess().getOverModulesModuleCrossReference_2_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_18);
                    	    ruleEString();

                    	    state._fsp--;


                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,27,FOLLOW_2); 

                    				newLeafNode(otherlv_6, grammarAccess.getElementAccess().getRightParenthesisKeyword_2_3());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleElement"


    // $ANTLR start "entryRuleFeatureElement"
    // InternalCaponeDsl.g:864:1: entryRuleFeatureElement returns [EObject current=null] : iv_ruleFeatureElement= ruleFeatureElement EOF ;
    public final EObject entryRuleFeatureElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureElement = null;


        try {
            // InternalCaponeDsl.g:864:55: (iv_ruleFeatureElement= ruleFeatureElement EOF )
            // InternalCaponeDsl.g:865:2: iv_ruleFeatureElement= ruleFeatureElement EOF
            {
             newCompositeNode(grammarAccess.getFeatureElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFeatureElement=ruleFeatureElement();

            state._fsp--;

             current =iv_ruleFeatureElement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFeatureElement"


    // $ANTLR start "ruleFeatureElement"
    // InternalCaponeDsl.g:871:1: ruleFeatureElement returns [EObject current=null] : ( () otherlv_1= '.' ( (lv_featureId_2_0= ruleEString ) ) ( (lv_feature_3_0= ruleFeatureElement ) )? ) ;
    public final EObject ruleFeatureElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_featureId_2_0 = null;

        EObject lv_feature_3_0 = null;



        	enterRule();

        try {
            // InternalCaponeDsl.g:877:2: ( ( () otherlv_1= '.' ( (lv_featureId_2_0= ruleEString ) ) ( (lv_feature_3_0= ruleFeatureElement ) )? ) )
            // InternalCaponeDsl.g:878:2: ( () otherlv_1= '.' ( (lv_featureId_2_0= ruleEString ) ) ( (lv_feature_3_0= ruleFeatureElement ) )? )
            {
            // InternalCaponeDsl.g:878:2: ( () otherlv_1= '.' ( (lv_featureId_2_0= ruleEString ) ) ( (lv_feature_3_0= ruleFeatureElement ) )? )
            // InternalCaponeDsl.g:879:3: () otherlv_1= '.' ( (lv_featureId_2_0= ruleEString ) ) ( (lv_feature_3_0= ruleFeatureElement ) )?
            {
            // InternalCaponeDsl.g:879:3: ()
            // InternalCaponeDsl.g:880:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFeatureElementAccess().getFeatureElementAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,28,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getFeatureElementAccess().getFullStopKeyword_1());
            		
            // InternalCaponeDsl.g:890:3: ( (lv_featureId_2_0= ruleEString ) )
            // InternalCaponeDsl.g:891:4: (lv_featureId_2_0= ruleEString )
            {
            // InternalCaponeDsl.g:891:4: (lv_featureId_2_0= ruleEString )
            // InternalCaponeDsl.g:892:5: lv_featureId_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getFeatureElementAccess().getFeatureIdEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_19);
            lv_featureId_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFeatureElementRule());
            					}
            					set(
            						current,
            						"featureId",
            						lv_featureId_2_0,
            						"capone.CaponeDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalCaponeDsl.g:909:3: ( (lv_feature_3_0= ruleFeatureElement ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==28) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalCaponeDsl.g:910:4: (lv_feature_3_0= ruleFeatureElement )
                    {
                    // InternalCaponeDsl.g:910:4: (lv_feature_3_0= ruleFeatureElement )
                    // InternalCaponeDsl.g:911:5: lv_feature_3_0= ruleFeatureElement
                    {

                    					newCompositeNode(grammarAccess.getFeatureElementAccess().getFeatureFeatureElementParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_feature_3_0=ruleFeatureElement();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getFeatureElementRule());
                    					}
                    					set(
                    						current,
                    						"feature",
                    						lv_feature_3_0,
                    						"capone.CaponeDsl.FeatureElement");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFeatureElement"


    // $ANTLR start "entryRuleRule"
    // InternalCaponeDsl.g:932:1: entryRuleRule returns [EObject current=null] : iv_ruleRule= ruleRule EOF ;
    public final EObject entryRuleRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRule = null;


        try {
            // InternalCaponeDsl.g:932:45: (iv_ruleRule= ruleRule EOF )
            // InternalCaponeDsl.g:933:2: iv_ruleRule= ruleRule EOF
            {
             newCompositeNode(grammarAccess.getRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRule=ruleRule();

            state._fsp--;

             current =iv_ruleRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRule"


    // $ANTLR start "ruleRule"
    // InternalCaponeDsl.g:939:1: ruleRule returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) (otherlv_1= 'extends' ( ( ruleQualifiedName ) ) )? ) ;
    public final EObject ruleRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;



        	enterRule();

        try {
            // InternalCaponeDsl.g:945:2: ( ( ( (lv_name_0_0= ruleEString ) ) (otherlv_1= 'extends' ( ( ruleQualifiedName ) ) )? ) )
            // InternalCaponeDsl.g:946:2: ( ( (lv_name_0_0= ruleEString ) ) (otherlv_1= 'extends' ( ( ruleQualifiedName ) ) )? )
            {
            // InternalCaponeDsl.g:946:2: ( ( (lv_name_0_0= ruleEString ) ) (otherlv_1= 'extends' ( ( ruleQualifiedName ) ) )? )
            // InternalCaponeDsl.g:947:3: ( (lv_name_0_0= ruleEString ) ) (otherlv_1= 'extends' ( ( ruleQualifiedName ) ) )?
            {
            // InternalCaponeDsl.g:947:3: ( (lv_name_0_0= ruleEString ) )
            // InternalCaponeDsl.g:948:4: (lv_name_0_0= ruleEString )
            {
            // InternalCaponeDsl.g:948:4: (lv_name_0_0= ruleEString )
            // InternalCaponeDsl.g:949:5: lv_name_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getRuleAccess().getNameEStringParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_20);
            lv_name_0_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRuleRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_0_0,
            						"capone.CaponeDsl.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalCaponeDsl.g:966:3: (otherlv_1= 'extends' ( ( ruleQualifiedName ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==29) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalCaponeDsl.g:967:4: otherlv_1= 'extends' ( ( ruleQualifiedName ) )
                    {
                    otherlv_1=(Token)match(input,29,FOLLOW_21); 

                    				newLeafNode(otherlv_1, grammarAccess.getRuleAccess().getExtendsKeyword_1_0());
                    			
                    // InternalCaponeDsl.g:971:4: ( ( ruleQualifiedName ) )
                    // InternalCaponeDsl.g:972:5: ( ruleQualifiedName )
                    {
                    // InternalCaponeDsl.g:972:5: ( ruleQualifiedName )
                    // InternalCaponeDsl.g:973:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRuleRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getRuleAccess().getExtendsruleRuleCrossReference_1_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRule"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalCaponeDsl.g:992:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalCaponeDsl.g:992:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalCaponeDsl.g:993:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalCaponeDsl.g:999:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalCaponeDsl.g:1005:2: ( (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID ) )
            // InternalCaponeDsl.g:1006:2: (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID )
            {
            // InternalCaponeDsl.g:1006:2: (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID )
            // InternalCaponeDsl.g:1007:3: this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_22); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            kw=(Token)match(input,28,FOLLOW_21); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1());
            		
            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_2); 

            			current.merge(this_ID_2);
            		

            			newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleFormula"
    // InternalCaponeDsl.g:1030:1: entryRuleFormula returns [EObject current=null] : iv_ruleFormula= ruleFormula EOF ;
    public final EObject entryRuleFormula() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFormula = null;


        try {
            // InternalCaponeDsl.g:1030:48: (iv_ruleFormula= ruleFormula EOF )
            // InternalCaponeDsl.g:1031:2: iv_ruleFormula= ruleFormula EOF
            {
             newCompositeNode(grammarAccess.getFormulaRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFormula=ruleFormula();

            state._fsp--;

             current =iv_ruleFormula; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFormula"


    // $ANTLR start "ruleFormula"
    // InternalCaponeDsl.g:1037:1: ruleFormula returns [EObject current=null] : ( (lv_term_0_0= ruleTerm ) ) ;
    public final EObject ruleFormula() throws RecognitionException {
        EObject current = null;

        EObject lv_term_0_0 = null;



        	enterRule();

        try {
            // InternalCaponeDsl.g:1043:2: ( ( (lv_term_0_0= ruleTerm ) ) )
            // InternalCaponeDsl.g:1044:2: ( (lv_term_0_0= ruleTerm ) )
            {
            // InternalCaponeDsl.g:1044:2: ( (lv_term_0_0= ruleTerm ) )
            // InternalCaponeDsl.g:1045:3: (lv_term_0_0= ruleTerm )
            {
            // InternalCaponeDsl.g:1045:3: (lv_term_0_0= ruleTerm )
            // InternalCaponeDsl.g:1046:4: lv_term_0_0= ruleTerm
            {

            				newCompositeNode(grammarAccess.getFormulaAccess().getTermTermParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_term_0_0=ruleTerm();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getFormulaRule());
            				}
            				set(
            					current,
            					"term",
            					lv_term_0_0,
            					"capone.CaponeDsl.Term");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFormula"


    // $ANTLR start "entryRuleTerm"
    // InternalCaponeDsl.g:1066:1: entryRuleTerm returns [EObject current=null] : iv_ruleTerm= ruleTerm EOF ;
    public final EObject entryRuleTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerm = null;


        try {
            // InternalCaponeDsl.g:1066:45: (iv_ruleTerm= ruleTerm EOF )
            // InternalCaponeDsl.g:1067:2: iv_ruleTerm= ruleTerm EOF
            {
             newCompositeNode(grammarAccess.getTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTerm=ruleTerm();

            state._fsp--;

             current =iv_ruleTerm; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTerm"


    // $ANTLR start "ruleTerm"
    // InternalCaponeDsl.g:1073:1: ruleTerm returns [EObject current=null] : ( (this_Simple_0= ruleSimple | this_Binary_1= ruleBinary ) ( (lv_next_2_0= ruleNextTerm ) )? ) ;
    public final EObject ruleTerm() throws RecognitionException {
        EObject current = null;

        EObject this_Simple_0 = null;

        EObject this_Binary_1 = null;

        EObject lv_next_2_0 = null;



        	enterRule();

        try {
            // InternalCaponeDsl.g:1079:2: ( ( (this_Simple_0= ruleSimple | this_Binary_1= ruleBinary ) ( (lv_next_2_0= ruleNextTerm ) )? ) )
            // InternalCaponeDsl.g:1080:2: ( (this_Simple_0= ruleSimple | this_Binary_1= ruleBinary ) ( (lv_next_2_0= ruleNextTerm ) )? )
            {
            // InternalCaponeDsl.g:1080:2: ( (this_Simple_0= ruleSimple | this_Binary_1= ruleBinary ) ( (lv_next_2_0= ruleNextTerm ) )? )
            // InternalCaponeDsl.g:1081:3: (this_Simple_0= ruleSimple | this_Binary_1= ruleBinary ) ( (lv_next_2_0= ruleNextTerm ) )?
            {
            // InternalCaponeDsl.g:1081:3: (this_Simple_0= ruleSimple | this_Binary_1= ruleBinary )
            int alt21=2;
            switch ( input.LA(1) ) {
            case 30:
                {
                int LA21_1 = input.LA(2);

                if ( ((LA21_1>=RULE_STRING && LA21_1<=RULE_ID)) ) {
                    alt21=1;
                }
                else if ( (LA21_1==26) ) {
                    alt21=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_STRING:
            case RULE_ID:
                {
                alt21=1;
                }
                break;
            case 26:
                {
                alt21=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // InternalCaponeDsl.g:1082:4: this_Simple_0= ruleSimple
                    {

                    				newCompositeNode(grammarAccess.getTermAccess().getSimpleParserRuleCall_0_0());
                    			
                    pushFollow(FOLLOW_23);
                    this_Simple_0=ruleSimple();

                    state._fsp--;


                    				current = this_Simple_0;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;
                case 2 :
                    // InternalCaponeDsl.g:1091:4: this_Binary_1= ruleBinary
                    {

                    				newCompositeNode(grammarAccess.getTermAccess().getBinaryParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_23);
                    this_Binary_1=ruleBinary();

                    state._fsp--;


                    				current = this_Binary_1;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }

            // InternalCaponeDsl.g:1100:3: ( (lv_next_2_0= ruleNextTerm ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=31 && LA22_0<=33)) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalCaponeDsl.g:1101:4: (lv_next_2_0= ruleNextTerm )
                    {
                    // InternalCaponeDsl.g:1101:4: (lv_next_2_0= ruleNextTerm )
                    // InternalCaponeDsl.g:1102:5: lv_next_2_0= ruleNextTerm
                    {

                    					newCompositeNode(grammarAccess.getTermAccess().getNextNextTermParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_next_2_0=ruleNextTerm();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getTermRule());
                    					}
                    					set(
                    						current,
                    						"next",
                    						lv_next_2_0,
                    						"capone.CaponeDsl.NextTerm");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerm"


    // $ANTLR start "entryRuleSimple"
    // InternalCaponeDsl.g:1123:1: entryRuleSimple returns [EObject current=null] : iv_ruleSimple= ruleSimple EOF ;
    public final EObject entryRuleSimple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimple = null;


        try {
            // InternalCaponeDsl.g:1123:47: (iv_ruleSimple= ruleSimple EOF )
            // InternalCaponeDsl.g:1124:2: iv_ruleSimple= ruleSimple EOF
            {
             newCompositeNode(grammarAccess.getSimpleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSimple=ruleSimple();

            state._fsp--;

             current =iv_ruleSimple; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSimple"


    // $ANTLR start "ruleSimple"
    // InternalCaponeDsl.g:1130:1: ruleSimple returns [EObject current=null] : ( ( (lv_uoperator_0_0= ruleUnaryOperator ) )? ( ( ruleEString ) ) ) ;
    public final EObject ruleSimple() throws RecognitionException {
        EObject current = null;

        Enumerator lv_uoperator_0_0 = null;



        	enterRule();

        try {
            // InternalCaponeDsl.g:1136:2: ( ( ( (lv_uoperator_0_0= ruleUnaryOperator ) )? ( ( ruleEString ) ) ) )
            // InternalCaponeDsl.g:1137:2: ( ( (lv_uoperator_0_0= ruleUnaryOperator ) )? ( ( ruleEString ) ) )
            {
            // InternalCaponeDsl.g:1137:2: ( ( (lv_uoperator_0_0= ruleUnaryOperator ) )? ( ( ruleEString ) ) )
            // InternalCaponeDsl.g:1138:3: ( (lv_uoperator_0_0= ruleUnaryOperator ) )? ( ( ruleEString ) )
            {
            // InternalCaponeDsl.g:1138:3: ( (lv_uoperator_0_0= ruleUnaryOperator ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==30) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalCaponeDsl.g:1139:4: (lv_uoperator_0_0= ruleUnaryOperator )
                    {
                    // InternalCaponeDsl.g:1139:4: (lv_uoperator_0_0= ruleUnaryOperator )
                    // InternalCaponeDsl.g:1140:5: lv_uoperator_0_0= ruleUnaryOperator
                    {

                    					newCompositeNode(grammarAccess.getSimpleAccess().getUoperatorUnaryOperatorEnumRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_4);
                    lv_uoperator_0_0=ruleUnaryOperator();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getSimpleRule());
                    					}
                    					set(
                    						current,
                    						"uoperator",
                    						lv_uoperator_0_0,
                    						"capone.CaponeDsl.UnaryOperator");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalCaponeDsl.g:1157:3: ( ( ruleEString ) )
            // InternalCaponeDsl.g:1158:4: ( ruleEString )
            {
            // InternalCaponeDsl.g:1158:4: ( ruleEString )
            // InternalCaponeDsl.g:1159:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSimpleRule());
            					}
            				

            					newCompositeNode(grammarAccess.getSimpleAccess().getVariableModuleCrossReference_1_0());
            				
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSimple"


    // $ANTLR start "entryRuleBinary"
    // InternalCaponeDsl.g:1177:1: entryRuleBinary returns [EObject current=null] : iv_ruleBinary= ruleBinary EOF ;
    public final EObject entryRuleBinary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinary = null;


        try {
            // InternalCaponeDsl.g:1177:47: (iv_ruleBinary= ruleBinary EOF )
            // InternalCaponeDsl.g:1178:2: iv_ruleBinary= ruleBinary EOF
            {
             newCompositeNode(grammarAccess.getBinaryRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBinary=ruleBinary();

            state._fsp--;

             current =iv_ruleBinary; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBinary"


    // $ANTLR start "ruleBinary"
    // InternalCaponeDsl.g:1184:1: ruleBinary returns [EObject current=null] : ( ( (lv_uoperator_0_0= ruleUnaryOperator ) )? otherlv_1= '(' ( (lv_operand1_2_0= ruleSimple ) ) ( (lv_boperator_3_0= ruleBinaryOperator ) ) ( (lv_operand2_4_0= ruleTerm ) ) otherlv_5= ')' ) ;
    public final EObject ruleBinary() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_5=null;
        Enumerator lv_uoperator_0_0 = null;

        EObject lv_operand1_2_0 = null;

        Enumerator lv_boperator_3_0 = null;

        EObject lv_operand2_4_0 = null;



        	enterRule();

        try {
            // InternalCaponeDsl.g:1190:2: ( ( ( (lv_uoperator_0_0= ruleUnaryOperator ) )? otherlv_1= '(' ( (lv_operand1_2_0= ruleSimple ) ) ( (lv_boperator_3_0= ruleBinaryOperator ) ) ( (lv_operand2_4_0= ruleTerm ) ) otherlv_5= ')' ) )
            // InternalCaponeDsl.g:1191:2: ( ( (lv_uoperator_0_0= ruleUnaryOperator ) )? otherlv_1= '(' ( (lv_operand1_2_0= ruleSimple ) ) ( (lv_boperator_3_0= ruleBinaryOperator ) ) ( (lv_operand2_4_0= ruleTerm ) ) otherlv_5= ')' )
            {
            // InternalCaponeDsl.g:1191:2: ( ( (lv_uoperator_0_0= ruleUnaryOperator ) )? otherlv_1= '(' ( (lv_operand1_2_0= ruleSimple ) ) ( (lv_boperator_3_0= ruleBinaryOperator ) ) ( (lv_operand2_4_0= ruleTerm ) ) otherlv_5= ')' )
            // InternalCaponeDsl.g:1192:3: ( (lv_uoperator_0_0= ruleUnaryOperator ) )? otherlv_1= '(' ( (lv_operand1_2_0= ruleSimple ) ) ( (lv_boperator_3_0= ruleBinaryOperator ) ) ( (lv_operand2_4_0= ruleTerm ) ) otherlv_5= ')'
            {
            // InternalCaponeDsl.g:1192:3: ( (lv_uoperator_0_0= ruleUnaryOperator ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==30) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalCaponeDsl.g:1193:4: (lv_uoperator_0_0= ruleUnaryOperator )
                    {
                    // InternalCaponeDsl.g:1193:4: (lv_uoperator_0_0= ruleUnaryOperator )
                    // InternalCaponeDsl.g:1194:5: lv_uoperator_0_0= ruleUnaryOperator
                    {

                    					newCompositeNode(grammarAccess.getBinaryAccess().getUoperatorUnaryOperatorEnumRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_24);
                    lv_uoperator_0_0=ruleUnaryOperator();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getBinaryRule());
                    					}
                    					set(
                    						current,
                    						"uoperator",
                    						lv_uoperator_0_0,
                    						"capone.CaponeDsl.UnaryOperator");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,26,FOLLOW_25); 

            			newLeafNode(otherlv_1, grammarAccess.getBinaryAccess().getLeftParenthesisKeyword_1());
            		
            // InternalCaponeDsl.g:1215:3: ( (lv_operand1_2_0= ruleSimple ) )
            // InternalCaponeDsl.g:1216:4: (lv_operand1_2_0= ruleSimple )
            {
            // InternalCaponeDsl.g:1216:4: (lv_operand1_2_0= ruleSimple )
            // InternalCaponeDsl.g:1217:5: lv_operand1_2_0= ruleSimple
            {

            					newCompositeNode(grammarAccess.getBinaryAccess().getOperand1SimpleParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_26);
            lv_operand1_2_0=ruleSimple();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBinaryRule());
            					}
            					set(
            						current,
            						"operand1",
            						lv_operand1_2_0,
            						"capone.CaponeDsl.Simple");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalCaponeDsl.g:1234:3: ( (lv_boperator_3_0= ruleBinaryOperator ) )
            // InternalCaponeDsl.g:1235:4: (lv_boperator_3_0= ruleBinaryOperator )
            {
            // InternalCaponeDsl.g:1235:4: (lv_boperator_3_0= ruleBinaryOperator )
            // InternalCaponeDsl.g:1236:5: lv_boperator_3_0= ruleBinaryOperator
            {

            					newCompositeNode(grammarAccess.getBinaryAccess().getBoperatorBinaryOperatorEnumRuleCall_3_0());
            				
            pushFollow(FOLLOW_7);
            lv_boperator_3_0=ruleBinaryOperator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBinaryRule());
            					}
            					set(
            						current,
            						"boperator",
            						lv_boperator_3_0,
            						"capone.CaponeDsl.BinaryOperator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalCaponeDsl.g:1253:3: ( (lv_operand2_4_0= ruleTerm ) )
            // InternalCaponeDsl.g:1254:4: (lv_operand2_4_0= ruleTerm )
            {
            // InternalCaponeDsl.g:1254:4: (lv_operand2_4_0= ruleTerm )
            // InternalCaponeDsl.g:1255:5: lv_operand2_4_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getBinaryAccess().getOperand2TermParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_27);
            lv_operand2_4_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBinaryRule());
            					}
            					set(
            						current,
            						"operand2",
            						lv_operand2_4_0,
            						"capone.CaponeDsl.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,27,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getBinaryAccess().getRightParenthesisKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBinary"


    // $ANTLR start "entryRuleNextTerm"
    // InternalCaponeDsl.g:1280:1: entryRuleNextTerm returns [EObject current=null] : iv_ruleNextTerm= ruleNextTerm EOF ;
    public final EObject entryRuleNextTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNextTerm = null;


        try {
            // InternalCaponeDsl.g:1280:49: (iv_ruleNextTerm= ruleNextTerm EOF )
            // InternalCaponeDsl.g:1281:2: iv_ruleNextTerm= ruleNextTerm EOF
            {
             newCompositeNode(grammarAccess.getNextTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNextTerm=ruleNextTerm();

            state._fsp--;

             current =iv_ruleNextTerm; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNextTerm"


    // $ANTLR start "ruleNextTerm"
    // InternalCaponeDsl.g:1287:1: ruleNextTerm returns [EObject current=null] : ( ( (lv_boperator_0_0= ruleBinaryOperator ) ) ( (lv_term_1_0= ruleTerm ) ) ) ;
    public final EObject ruleNextTerm() throws RecognitionException {
        EObject current = null;

        Enumerator lv_boperator_0_0 = null;

        EObject lv_term_1_0 = null;



        	enterRule();

        try {
            // InternalCaponeDsl.g:1293:2: ( ( ( (lv_boperator_0_0= ruleBinaryOperator ) ) ( (lv_term_1_0= ruleTerm ) ) ) )
            // InternalCaponeDsl.g:1294:2: ( ( (lv_boperator_0_0= ruleBinaryOperator ) ) ( (lv_term_1_0= ruleTerm ) ) )
            {
            // InternalCaponeDsl.g:1294:2: ( ( (lv_boperator_0_0= ruleBinaryOperator ) ) ( (lv_term_1_0= ruleTerm ) ) )
            // InternalCaponeDsl.g:1295:3: ( (lv_boperator_0_0= ruleBinaryOperator ) ) ( (lv_term_1_0= ruleTerm ) )
            {
            // InternalCaponeDsl.g:1295:3: ( (lv_boperator_0_0= ruleBinaryOperator ) )
            // InternalCaponeDsl.g:1296:4: (lv_boperator_0_0= ruleBinaryOperator )
            {
            // InternalCaponeDsl.g:1296:4: (lv_boperator_0_0= ruleBinaryOperator )
            // InternalCaponeDsl.g:1297:5: lv_boperator_0_0= ruleBinaryOperator
            {

            					newCompositeNode(grammarAccess.getNextTermAccess().getBoperatorBinaryOperatorEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_7);
            lv_boperator_0_0=ruleBinaryOperator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNextTermRule());
            					}
            					set(
            						current,
            						"boperator",
            						lv_boperator_0_0,
            						"capone.CaponeDsl.BinaryOperator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalCaponeDsl.g:1314:3: ( (lv_term_1_0= ruleTerm ) )
            // InternalCaponeDsl.g:1315:4: (lv_term_1_0= ruleTerm )
            {
            // InternalCaponeDsl.g:1315:4: (lv_term_1_0= ruleTerm )
            // InternalCaponeDsl.g:1316:5: lv_term_1_0= ruleTerm
            {

            					newCompositeNode(grammarAccess.getNextTermAccess().getTermTermParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_term_1_0=ruleTerm();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNextTermRule());
            					}
            					set(
            						current,
            						"term",
            						lv_term_1_0,
            						"capone.CaponeDsl.Term");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNextTerm"


    // $ANTLR start "ruleUnaryOperator"
    // InternalCaponeDsl.g:1337:1: ruleUnaryOperator returns [Enumerator current=null] : (enumLiteral_0= 'not' ) ;
    public final Enumerator ruleUnaryOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;


        	enterRule();

        try {
            // InternalCaponeDsl.g:1343:2: ( (enumLiteral_0= 'not' ) )
            // InternalCaponeDsl.g:1344:2: (enumLiteral_0= 'not' )
            {
            // InternalCaponeDsl.g:1344:2: (enumLiteral_0= 'not' )
            // InternalCaponeDsl.g:1345:3: enumLiteral_0= 'not'
            {
            enumLiteral_0=(Token)match(input,30,FOLLOW_2); 

            			current = grammarAccess.getUnaryOperatorAccess().getNotEnumLiteralDeclaration().getEnumLiteral().getInstance();
            			newLeafNode(enumLiteral_0, grammarAccess.getUnaryOperatorAccess().getNotEnumLiteralDeclaration());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryOperator"


    // $ANTLR start "ruleBinaryOperator"
    // InternalCaponeDsl.g:1354:1: ruleBinaryOperator returns [Enumerator current=null] : ( (enumLiteral_0= 'and' ) | (enumLiteral_1= 'or' ) | (enumLiteral_2= 'implies' ) ) ;
    public final Enumerator ruleBinaryOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalCaponeDsl.g:1360:2: ( ( (enumLiteral_0= 'and' ) | (enumLiteral_1= 'or' ) | (enumLiteral_2= 'implies' ) ) )
            // InternalCaponeDsl.g:1361:2: ( (enumLiteral_0= 'and' ) | (enumLiteral_1= 'or' ) | (enumLiteral_2= 'implies' ) )
            {
            // InternalCaponeDsl.g:1361:2: ( (enumLiteral_0= 'and' ) | (enumLiteral_1= 'or' ) | (enumLiteral_2= 'implies' ) )
            int alt25=3;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt25=1;
                }
                break;
            case 32:
                {
                alt25=2;
                }
                break;
            case 33:
                {
                alt25=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // InternalCaponeDsl.g:1362:3: (enumLiteral_0= 'and' )
                    {
                    // InternalCaponeDsl.g:1362:3: (enumLiteral_0= 'and' )
                    // InternalCaponeDsl.g:1363:4: enumLiteral_0= 'and'
                    {
                    enumLiteral_0=(Token)match(input,31,FOLLOW_2); 

                    				current = grammarAccess.getBinaryOperatorAccess().getAndEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getBinaryOperatorAccess().getAndEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalCaponeDsl.g:1370:3: (enumLiteral_1= 'or' )
                    {
                    // InternalCaponeDsl.g:1370:3: (enumLiteral_1= 'or' )
                    // InternalCaponeDsl.g:1371:4: enumLiteral_1= 'or'
                    {
                    enumLiteral_1=(Token)match(input,32,FOLLOW_2); 

                    				current = grammarAccess.getBinaryOperatorAccess().getOrEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getBinaryOperatorAccess().getOrEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalCaponeDsl.g:1378:3: (enumLiteral_2= 'implies' )
                    {
                    // InternalCaponeDsl.g:1378:3: (enumLiteral_2= 'implies' )
                    // InternalCaponeDsl.g:1379:4: enumLiteral_2= 'implies'
                    {
                    enumLiteral_2=(Token)match(input,33,FOLLOW_2); 

                    				current = grammarAccess.getBinaryOperatorAccess().getImpliesEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getBinaryOperatorAccess().getImpliesEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBinaryOperator"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00000000007DC000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000044000030L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000FDC000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000FFC000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000800030L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000820000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000003800000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000002820000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000014000002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000008020000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000380000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000040000030L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000380000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000008000000L});

}
