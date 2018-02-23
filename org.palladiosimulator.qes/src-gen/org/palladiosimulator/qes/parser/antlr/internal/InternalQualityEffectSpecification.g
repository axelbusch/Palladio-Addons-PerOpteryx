/*
 * generated by Xtext 2.13.0
 */
grammar InternalQualityEffectSpecification;

options {
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package org.palladiosimulator.qes.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.palladiosimulator.qes.parser.antlr.internal;

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
import org.palladiosimulator.qes.services.QualityEffectSpecificationGrammarAccess;

}

@parser::members {

 	private QualityEffectSpecificationGrammarAccess grammarAccess;

    public InternalQualityEffectSpecificationParser(TokenStream input, QualityEffectSpecificationGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }

    @Override
    protected String getFirstRuleName() {
    	return "Model";
   	}

   	@Override
   	protected QualityEffectSpecificationGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}

}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}

// Entry rule entryRuleModel
entryRuleModel returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getModelRule()); }
	iv_ruleModel=ruleModel
	{ $current=$iv_ruleModel.current; }
	EOF;

// Rule Model
ruleModel returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					newCompositeNode(grammarAccess.getModelAccess().getComponentsComponentParserRuleCall_0_0());
				}
				lv_components_0_0=ruleComponent
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getModelRule());
					}
					add(
						$current,
						"components",
						lv_components_0_0,
						"org.palladiosimulator.qes.QualityEffectSpecification.Component");
					afterParserOrEnumRuleCall();
				}
			)
		)+
		otherlv_1=':'
		{
			newLeafNode(otherlv_1, grammarAccess.getModelAccess().getColonKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getModelAccess().getTransformationsTransformationParserRuleCall_2_0());
				}
				lv_transformations_2_0=ruleTransformation
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getModelRule());
					}
					add(
						$current,
						"transformations",
						lv_transformations_2_0,
						"org.palladiosimulator.qes.QualityEffectSpecification.Transformation");
					afterParserOrEnumRuleCall();
				}
			)
		)+
	)
;

// Entry rule entryRuleComponent
entryRuleComponent returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getComponentRule()); }
	iv_ruleComponent=ruleComponent
	{ $current=$iv_ruleComponent.current; }
	EOF;

// Rule Component
ruleComponent returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='Component('
		{
			newLeafNode(otherlv_0, grammarAccess.getComponentAccess().getComponentKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getComponentAccess().getPropertiesPropertieParserRuleCall_1_0());
				}
				lv_properties_1_0=rulePropertie
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getComponentRule());
					}
					add(
						$current,
						"properties",
						lv_properties_1_0,
						"org.palladiosimulator.qes.QualityEffectSpecification.Propertie");
					afterParserOrEnumRuleCall();
				}
			)
		)+
		otherlv_2=')'
		{
			newLeafNode(otherlv_2, grammarAccess.getComponentAccess().getRightParenthesisKeyword_2());
		}
	)
;

// Entry rule entryRulePropertie
entryRulePropertie returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPropertieRule()); }
	iv_rulePropertie=rulePropertie
	{ $current=$iv_rulePropertie.current; }
	EOF;

// Rule Propertie
rulePropertie returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getPropertieAccess().getNegationParserRuleCall_0());
		}
		this_Negation_0=ruleNegation
		{
			$current = $this_Negation_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getPropertieAccess().getComponentPropertieParserRuleCall_1());
		}
		this_ComponentPropertie_1=ruleComponentPropertie
		{
			$current = $this_ComponentPropertie_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleNegation
entryRuleNegation returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getNegationRule()); }
	iv_ruleNegation=ruleNegation
	{ $current=$iv_ruleNegation.current; }
	EOF;

// Rule Negation
ruleNegation returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='Not('
		{
			newLeafNode(otherlv_0, grammarAccess.getNegationAccess().getNotKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getNegationAccess().getPropertieComponentPropertieParserRuleCall_1_0());
				}
				lv_propertie_1_0=ruleComponentPropertie
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getNegationRule());
					}
					set(
						$current,
						"propertie",
						lv_propertie_1_0,
						"org.palladiosimulator.qes.QualityEffectSpecification.ComponentPropertie");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2=')'
		{
			newLeafNode(otherlv_2, grammarAccess.getNegationAccess().getRightParenthesisKeyword_2());
		}
	)
;

// Entry rule entryRuleComponentPropertie
entryRuleComponentPropertie returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getComponentPropertieRule()); }
	iv_ruleComponentPropertie=ruleComponentPropertie
	{ $current=$iv_ruleComponentPropertie.current; }
	EOF;

// Rule ComponentPropertie
ruleComponentPropertie returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getComponentPropertieAccess().getNameParserRuleCall_0());
		}
		this_Name_0=ruleName
		{
			$current = $this_Name_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getComponentPropertieAccess().getIdentifierParserRuleCall_1());
		}
		this_Identifier_1=ruleIdentifier
		{
			$current = $this_Identifier_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getComponentPropertieAccess().getTypeParserRuleCall_2());
		}
		this_Type_2=ruleType
		{
			$current = $this_Type_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getComponentPropertieAccess().getRoleParserRuleCall_3());
		}
		this_Role_3=ruleRole
		{
			$current = $this_Role_3.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getComponentPropertieAccess().getAssemblyParserRuleCall_4());
		}
		this_Assembly_4=ruleAssembly
		{
			$current = $this_Assembly_4.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleName
entryRuleName returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getNameRule()); }
	iv_ruleName=ruleName
	{ $current=$iv_ruleName.current; }
	EOF;

// Rule Name
ruleName returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='Name('
		{
			newLeafNode(otherlv_0, grammarAccess.getNameAccess().getNameKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getNameAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getNameRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		otherlv_2=')'
		{
			newLeafNode(otherlv_2, grammarAccess.getNameAccess().getRightParenthesisKeyword_2());
		}
	)
;

// Entry rule entryRuleIdentifier
entryRuleIdentifier returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getIdentifierRule()); }
	iv_ruleIdentifier=ruleIdentifier
	{ $current=$iv_ruleIdentifier.current; }
	EOF;

// Rule Identifier
ruleIdentifier returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='Id('
		{
			newLeafNode(otherlv_0, grammarAccess.getIdentifierAccess().getIdKeyword_0());
		}
		(
			(
				lv_id_1_0=RULE_ID
				{
					newLeafNode(lv_id_1_0, grammarAccess.getIdentifierAccess().getIdIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getIdentifierRule());
					}
					setWithLastConsumed(
						$current,
						"id",
						lv_id_1_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		otherlv_2=')'
		{
			newLeafNode(otherlv_2, grammarAccess.getIdentifierAccess().getRightParenthesisKeyword_2());
		}
	)
;

// Entry rule entryRuleType
entryRuleType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTypeRule()); }
	iv_ruleType=ruleType
	{ $current=$iv_ruleType.current; }
	EOF;

// Rule Type
ruleType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='Type('
		{
			newLeafNode(otherlv_0, grammarAccess.getTypeAccess().getTypeKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getTypeAccess().getTypeComponentTypeEnumRuleCall_1_0());
				}
				lv_type_1_0=ruleComponentType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTypeRule());
					}
					set(
						$current,
						"type",
						lv_type_1_0,
						"org.palladiosimulator.qes.QualityEffectSpecification.ComponentType");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_2=')'
		{
			newLeafNode(otherlv_2, grammarAccess.getTypeAccess().getRightParenthesisKeyword_2());
		}
	)
;

// Entry rule entryRuleRole
entryRuleRole returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getRoleRule()); }
	iv_ruleRole=ruleRole
	{ $current=$iv_ruleRole.current; }
	EOF;

// Rule Role
ruleRole returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='Role('
		{
			newLeafNode(otherlv_0, grammarAccess.getRoleAccess().getRoleKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getRoleAccess().getTypesRoleTypeEnumRuleCall_1_0());
				}
				lv_types_1_0=ruleRoleType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getRoleRule());
					}
					add(
						$current,
						"types",
						lv_types_1_0,
						"org.palladiosimulator.qes.QualityEffectSpecification.RoleType");
					afterParserOrEnumRuleCall();
				}
			)
		)+
		(
			(
				{
					newCompositeNode(grammarAccess.getRoleAccess().getPropertiesRolePropertieParserRuleCall_2_0());
				}
				lv_properties_2_0=ruleRolePropertie
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getRoleRule());
					}
					add(
						$current,
						"properties",
						lv_properties_2_0,
						"org.palladiosimulator.qes.QualityEffectSpecification.RolePropertie");
					afterParserOrEnumRuleCall();
				}
			)
		)+
		otherlv_3=')'
		{
			newLeafNode(otherlv_3, grammarAccess.getRoleAccess().getRightParenthesisKeyword_3());
		}
	)
;

// Entry rule entryRuleRolePropertie
entryRuleRolePropertie returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getRolePropertieRule()); }
	iv_ruleRolePropertie=ruleRolePropertie
	{ $current=$iv_ruleRolePropertie.current; }
	EOF;

// Rule RolePropertie
ruleRolePropertie returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getRolePropertieAccess().getNameParserRuleCall_0());
		}
		this_Name_0=ruleName
		{
			$current = $this_Name_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getRolePropertieAccess().getIdentifierParserRuleCall_1());
		}
		this_Identifier_1=ruleIdentifier
		{
			$current = $this_Identifier_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleAssembly
entryRuleAssembly returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAssemblyRule()); }
	iv_ruleAssembly=ruleAssembly
	{ $current=$iv_ruleAssembly.current; }
	EOF;

// Rule Assembly
ruleAssembly returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='Assembly('
		{
			newLeafNode(otherlv_0, grammarAccess.getAssemblyAccess().getAssemblyKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getAssemblyAccess().getAssemblyTypeAssemblyTypeEnumRuleCall_1_0());
				}
				lv_assemblyType_1_0=ruleAssemblyType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getAssemblyRule());
					}
					set(
						$current,
						"assemblyType",
						lv_assemblyType_1_0,
						"org.palladiosimulator.qes.QualityEffectSpecification.AssemblyType");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getAssemblyAccess().getAssemblyComponentComponentParserRuleCall_2_0());
				}
				lv_assemblyComponent_2_0=ruleComponent
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getAssemblyRule());
					}
					set(
						$current,
						"assemblyComponent",
						lv_assemblyComponent_2_0,
						"org.palladiosimulator.qes.QualityEffectSpecification.Component");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3=')'
		{
			newLeafNode(otherlv_3, grammarAccess.getAssemblyAccess().getRightParenthesisKeyword_3());
		}
	)
;

// Entry rule entryRuleTransformation
entryRuleTransformation returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTransformationRule()); }
	iv_ruleTransformation=ruleTransformation
	{ $current=$iv_ruleTransformation.current; }
	EOF;

// Rule Transformation
ruleTransformation returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getTransformationAccess().getNQAParserRuleCall_0());
		}
		this_NQA_0=ruleNQA
		{
			$current = $this_NQA_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getTransformationAccess().getReasoningParserRuleCall_1());
		}
		this_Reasoning_1=ruleReasoning
		{
			$current = $this_Reasoning_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleNQA
entryRuleNQA returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getNQARule()); }
	iv_ruleNQA=ruleNQA
	{ $current=$iv_ruleNQA.current; }
	EOF;

// Rule NQA
ruleNQA returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='NQA('
		{
			newLeafNode(otherlv_0, grammarAccess.getNQAAccess().getNQAKeyword_0());
		}
		(
			(
				lv_quality_1_0=RULE_ID
				{
					newLeafNode(lv_quality_1_0, grammarAccess.getNQAAccess().getQualityIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getNQARule());
					}
					setWithLastConsumed(
						$current,
						"quality",
						lv_quality_1_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		otherlv_2='='
		{
			newLeafNode(otherlv_2, grammarAccess.getNQAAccess().getEqualsSignKeyword_2());
		}
		(
			(
				lv_element_3_0=RULE_ID
				{
					newLeafNode(lv_element_3_0, grammarAccess.getNQAAccess().getElementIDTerminalRuleCall_3_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getNQARule());
					}
					setWithLastConsumed(
						$current,
						"element",
						lv_element_3_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		otherlv_4=')'
		{
			newLeafNode(otherlv_4, grammarAccess.getNQAAccess().getRightParenthesisKeyword_4());
		}
	)
;

// Entry rule entryRuleReasoning
entryRuleReasoning returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getReasoningRule()); }
	iv_ruleReasoning=ruleReasoning
	{ $current=$iv_ruleReasoning.current; }
	EOF;

// Rule Reasoning
ruleReasoning returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='Reasoning('
		{
			newLeafNode(otherlv_0, grammarAccess.getReasoningAccess().getReasoningKeyword_0());
		}
		(
			(
				lv_quality_1_0=RULE_ID
				{
					newLeafNode(lv_quality_1_0, grammarAccess.getReasoningAccess().getQualityIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getReasoningRule());
					}
					setWithLastConsumed(
						$current,
						"quality",
						lv_quality_1_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		otherlv_2='{'
		{
			newLeafNode(otherlv_2, grammarAccess.getReasoningAccess().getLeftCurlyBracketKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getReasoningAccess().getRulesRuleParserRuleCall_3_0());
				}
				lv_rules_3_0=ruleRule
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getReasoningRule());
					}
					add(
						$current,
						"rules",
						lv_rules_3_0,
						"org.palladiosimulator.qes.QualityEffectSpecification.Rule");
					afterParserOrEnumRuleCall();
				}
			)
		)+
		otherlv_4='})'
		{
			newLeafNode(otherlv_4, grammarAccess.getReasoningAccess().getRightCurlyBracketRightParenthesisKeyword_4());
		}
	)
;

// Entry rule entryRuleRule
entryRuleRule returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getRuleRule()); }
	iv_ruleRule=ruleRule
	{ $current=$iv_ruleRule.current; }
	EOF;

// Rule Rule
ruleRule returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='('
		{
			newLeafNode(otherlv_0, grammarAccess.getRuleAccess().getLeftParenthesisKeyword_0());
		}
		(
			(
				lv_qualities_1_0=RULE_ID
				{
					newLeafNode(lv_qualities_1_0, grammarAccess.getRuleAccess().getQualitiesIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getRuleRule());
					}
					addWithLastConsumed(
						$current,
						"qualities",
						lv_qualities_1_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)+
		otherlv_2='='
		{
			newLeafNode(otherlv_2, grammarAccess.getRuleAccess().getEqualsSignKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getRuleAccess().getEntriesEntryParserRuleCall_3_0());
				}
				lv_entries_3_0=ruleEntry
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getRuleRule());
					}
					add(
						$current,
						"entries",
						lv_entries_3_0,
						"org.palladiosimulator.qes.QualityEffectSpecification.Entry");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_4=')'
		{
			newLeafNode(otherlv_4, grammarAccess.getRuleAccess().getRightParenthesisKeyword_4());
		}
	)
;

// Entry rule entryRuleEntry
entryRuleEntry returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEntryRule()); }
	iv_ruleEntry=ruleEntry
	{ $current=$iv_ruleEntry.current; }
	EOF;

// Rule Entry
ruleEntry returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='['
		{
			newLeafNode(otherlv_0, grammarAccess.getEntryAccess().getLeftSquareBracketKeyword_0());
		}
		(
			(
				lv_key_1_0=RULE_ID
				{
					newLeafNode(lv_key_1_0, grammarAccess.getEntryAccess().getKeyIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntryRule());
					}
					addWithLastConsumed(
						$current,
						"key",
						lv_key_1_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)+
		otherlv_2='='
		{
			newLeafNode(otherlv_2, grammarAccess.getEntryAccess().getEqualsSignKeyword_2());
		}
		(
			(
				lv_value_3_0=RULE_ID
				{
					newLeafNode(lv_value_3_0, grammarAccess.getEntryAccess().getValueIDTerminalRuleCall_3_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEntryRule());
					}
					setWithLastConsumed(
						$current,
						"value",
						lv_value_3_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		otherlv_4=']'
		{
			newLeafNode(otherlv_4, grammarAccess.getEntryAccess().getRightSquareBracketKeyword_4());
		}
	)
;

// Rule ComponentType
ruleComponentType returns [Enumerator current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			enumLiteral_0='basic'
			{
				$current = grammarAccess.getComponentTypeAccess().getBASICEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_0, grammarAccess.getComponentTypeAccess().getBASICEnumLiteralDeclaration_0());
			}
		)
		    |
		(
			enumLiteral_1='composite'
			{
				$current = grammarAccess.getComponentTypeAccess().getCOMPOSITEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_1, grammarAccess.getComponentTypeAccess().getCOMPOSITEEnumLiteralDeclaration_1());
			}
		)
	)
;

// Rule RoleType
ruleRoleType returns [Enumerator current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			enumLiteral_0='required'
			{
				$current = grammarAccess.getRoleTypeAccess().getREQUIREDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_0, grammarAccess.getRoleTypeAccess().getREQUIREDEnumLiteralDeclaration_0());
			}
		)
		    |
		(
			enumLiteral_1='provided'
			{
				$current = grammarAccess.getRoleTypeAccess().getPROVIDEDEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_1, grammarAccess.getRoleTypeAccess().getPROVIDEDEnumLiteralDeclaration_1());
			}
		)
		    |
		(
			enumLiteral_2='component'
			{
				$current = grammarAccess.getRoleTypeAccess().getCOMPONENTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_2, grammarAccess.getRoleTypeAccess().getCOMPONENTEnumLiteralDeclaration_2());
			}
		)
		    |
		(
			enumLiteral_3='infrastructure'
			{
				$current = grammarAccess.getRoleTypeAccess().getINFRASTRUCTUREEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_3, grammarAccess.getRoleTypeAccess().getINFRASTRUCTUREEnumLiteralDeclaration_3());
			}
		)
	)
;

// Rule AssemblyType
ruleAssemblyType returns [Enumerator current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			enumLiteral_0='required'
			{
				$current = grammarAccess.getAssemblyTypeAccess().getREQUIREDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_0, grammarAccess.getAssemblyTypeAccess().getREQUIREDEnumLiteralDeclaration_0());
			}
		)
		    |
		(
			enumLiteral_1='provided'
			{
				$current = grammarAccess.getAssemblyTypeAccess().getPROVIDEDEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_1, grammarAccess.getAssemblyTypeAccess().getPROVIDEDEnumLiteralDeclaration_1());
			}
		)
		    |
		(
			enumLiteral_2='assembly'
			{
				$current = grammarAccess.getAssemblyTypeAccess().getASSEMBLYEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_2, grammarAccess.getAssemblyTypeAccess().getASSEMBLYEnumLiteralDeclaration_2());
			}
		)
	)
;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
