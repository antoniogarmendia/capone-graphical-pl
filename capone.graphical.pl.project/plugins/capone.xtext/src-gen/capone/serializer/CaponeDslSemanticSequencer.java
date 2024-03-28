/*
 * generated by Xtext 2.32.0
 */
package capone.serializer;

import capone.BinaryTerm;
import capone.CaponePackage;
import capone.Diagram;
import capone.Element;
import capone.FeatureElement;
import capone.Formula;
import capone.NextTerm;
import capone.Rule;
import capone.RuleSet;
import capone.UnaryTerm;
import capone.services.CaponeDslGrammarAccess;
import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class CaponeDslSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private CaponeDslGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == CaponePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case CaponePackage.BINARY_TERM:
				if (rule == grammarAccess.getBinaryRule()) {
					sequence_Binary(context, (BinaryTerm) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getTermRule()) {
					sequence_Binary_Term(context, (BinaryTerm) semanticObject); 
					return; 
				}
				else break;
			case CaponePackage.DIAGRAM:
				sequence_Diagram(context, (Diagram) semanticObject); 
				return; 
			case CaponePackage.ELEMENT:
				sequence_Element(context, (Element) semanticObject); 
				return; 
			case CaponePackage.FEATURE_ELEMENT:
				sequence_FeatureElement(context, (FeatureElement) semanticObject); 
				return; 
			case CaponePackage.FORMULA:
				sequence_Formula(context, (Formula) semanticObject); 
				return; 
			case CaponePackage.MODULE:
				sequence_Module(context, (capone.Module) semanticObject); 
				return; 
			case CaponePackage.NEXT_TERM:
				sequence_NextTerm(context, (NextTerm) semanticObject); 
				return; 
			case CaponePackage.RULE:
				sequence_Rule(context, (Rule) semanticObject); 
				return; 
			case CaponePackage.RULE_SET:
				sequence_RuleSet(context, (RuleSet) semanticObject); 
				return; 
			case CaponePackage.UNARY_TERM:
				if (rule == grammarAccess.getTermRule()) {
					sequence_Simple_Term(context, (UnaryTerm) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getSimpleRule()) {
					sequence_Simple(context, (UnaryTerm) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     Binary returns BinaryTerm
	 *
	 * Constraint:
	 *     (uoperator=UnaryOperator? operand1=Simple boperator=BinaryOperator operand2=Term)
	 * </pre>
	 */
	protected void sequence_Binary(ISerializationContext context, BinaryTerm semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Term returns BinaryTerm
	 *
	 * Constraint:
	 *     (uoperator=UnaryOperator? operand1=Simple boperator=BinaryOperator operand2=Term next=NextTerm?)
	 * </pre>
	 */
	protected void sequence_Binary_Term(ISerializationContext context, BinaryTerm semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Diagram returns Diagram
	 *
	 * Constraint:
	 *     (viewpointFileURI=EString (overridesElements+=Element overridesElements+=Element*)? (merge+=Element merge+=Element*)?)
	 * </pre>
	 */
	protected void sequence_Diagram(ISerializationContext context, Diagram semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Element returns Element
	 *
	 * Constraint:
	 *     (elementId=EString feature=FeatureElement? (overModules+=[Module|EString] overModules+=[Module|EString]*)?)
	 * </pre>
	 */
	protected void sequence_Element(ISerializationContext context, Element semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     FeatureElement returns FeatureElement
	 *
	 * Constraint:
	 *     (featureId=EString feature=FeatureElement?)
	 * </pre>
	 */
	protected void sequence_FeatureElement(ISerializationContext context, FeatureElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Formula returns Formula
	 *
	 * Constraint:
	 *     term=Term
	 * </pre>
	 */
	protected void sequence_Formula(ISerializationContext context, Formula semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, CaponePackage.Literals.FORMULA__TERM) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CaponePackage.Literals.FORMULA__TERM));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getFormulaAccess().getTermTermParserRuleCall_0(), semanticObject.getTerm());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Module returns Module
	 *
	 * Constraint:
	 *     (
	 *         isTop?='top'? 
	 *         name=EString 
	 *         (
	 *             (rules=RuleSet | chooseDiagram=Diagram)? 
	 *             (moduleMandatory+=[Module|EString] moduleMandatory+=[Module|EString]*)? 
	 *             (moduleOptional+=[Module|EString] moduleOptional+=[Module|EString]*)? 
	 *             (moduleAlternative+=[Module|EString] moduleAlternative+=[Module|EString]*)? 
	 *             (moduleOr+=[Module|EString] moduleOr+=[Module|EString]*)? 
	 *             (formula=Formula? metamodel=EString)?
	 *         )+
	 *     )
	 * </pre>
	 */
	protected void sequence_Module(ISerializationContext context, capone.Module semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     NextTerm returns NextTerm
	 *
	 * Constraint:
	 *     (boperator=BinaryOperator term=Term)
	 * </pre>
	 */
	protected void sequence_NextTerm(ISerializationContext context, NextTerm semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, CaponePackage.Literals.NEXT_TERM__BOPERATOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CaponePackage.Literals.NEXT_TERM__BOPERATOR));
			if (transientValues.isValueTransient(semanticObject, CaponePackage.Literals.NEXT_TERM__TERM) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CaponePackage.Literals.NEXT_TERM__TERM));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getNextTermAccess().getBoperatorBinaryOperatorEnumRuleCall_0_0(), semanticObject.getBoperator());
		feeder.accept(grammarAccess.getNextTermAccess().getTermTermParserRuleCall_1_0(), semanticObject.getTerm());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     RuleSet returns RuleSet
	 *
	 * Constraint:
	 *     (rulefile=EString (rules+=Rule rules+=Rule*)?)
	 * </pre>
	 */
	protected void sequence_RuleSet(ISerializationContext context, RuleSet semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Rule returns Rule
	 *
	 * Constraint:
	 *     (name=EString extendsrule=[Rule|QualifiedName]?)
	 * </pre>
	 */
	protected void sequence_Rule(ISerializationContext context, Rule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Term returns UnaryTerm
	 *
	 * Constraint:
	 *     (uoperator=UnaryOperator? variable=[Module|EString] next=NextTerm?)
	 * </pre>
	 */
	protected void sequence_Simple_Term(ISerializationContext context, UnaryTerm semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Simple returns UnaryTerm
	 *
	 * Constraint:
	 *     (uoperator=UnaryOperator? variable=[Module|EString])
	 * </pre>
	 */
	protected void sequence_Simple(ISerializationContext context, UnaryTerm semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
