/*
 * generated by Xtext 2.12.0
 */
package org.palladiosimulator.qes.ide.contentassist.antlr;

import com.google.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.palladiosimulator.qes.ide.contentassist.antlr.internal.InternalQualityEffectSpecificationParser;
import org.palladiosimulator.qes.services.QualityEffectSpecificationGrammarAccess;

public class QualityEffectSpecificationParser extends AbstractContentAssistParser {

	@Inject
	private QualityEffectSpecificationGrammarAccess grammarAccess;

	private Map<AbstractElement, String> nameMappings;

	@Override
	protected InternalQualityEffectSpecificationParser createParser() {
		InternalQualityEffectSpecificationParser result = new InternalQualityEffectSpecificationParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getComponentPropertyAccess().getAlternatives(), "rule__ComponentProperty__Alternatives");
					put(grammarAccess.getRolePropertyAccess().getAlternatives(), "rule__RoleProperty__Alternatives");
					put(grammarAccess.getResourcePropertyAccess().getAlternatives(), "rule__ResourceProperty__Alternatives");
					put(grammarAccess.getTransformationSpecificationAccess().getAlternatives(), "rule__TransformationSpecification__Alternatives");
					put(grammarAccess.getComponentTypeAccess().getAlternatives(), "rule__ComponentType__Alternatives");
					put(grammarAccess.getRoleTypeAccess().getAlternatives(), "rule__RoleType__Alternatives");
					put(grammarAccess.getAssemblyTypeAccess().getAlternatives(), "rule__AssemblyType__Alternatives");
					put(grammarAccess.getTransformationTypeAccess().getAlternatives(), "rule__TransformationType__Alternatives");
					put(grammarAccess.getModelAccess().getGroup(), "rule__Model__Group__0");
					put(grammarAccess.getModelAccess().getGroup_1(), "rule__Model__Group_1__0");
					put(grammarAccess.getQualityEffectSpecificationAccess().getGroup(), "rule__QualityEffectSpecification__Group__0");
					put(grammarAccess.getQualityEffectSpecificationAccess().getGroup_3(), "rule__QualityEffectSpecification__Group_3__0");
					put(grammarAccess.getQualityEffectSpecificationAccess().getGroup_8(), "rule__QualityEffectSpecification__Group_8__0");
					put(grammarAccess.getComponentSpecificationAccess().getGroup(), "rule__ComponentSpecification__Group__0");
					put(grammarAccess.getComponentSpecificationAccess().getGroup_3(), "rule__ComponentSpecification__Group_3__0");
					put(grammarAccess.getNameAccess().getGroup(), "rule__Name__Group__0");
					put(grammarAccess.getIdentifierAccess().getGroup(), "rule__Identifier__Group__0");
					put(grammarAccess.getAnnotationAccess().getGroup(), "rule__Annotation__Group__0");
					put(grammarAccess.getTypeAccess().getGroup(), "rule__Type__Group__0");
					put(grammarAccess.getRoleAccess().getGroup(), "rule__Role__Group__0");
					put(grammarAccess.getRoleAccess().getGroup_4(), "rule__Role__Group_4__0");
					put(grammarAccess.getRoleAccess().getGroup_4_2(), "rule__Role__Group_4_2__0");
					put(grammarAccess.getAssemblyAccess().getGroup(), "rule__Assembly__Group__0");
					put(grammarAccess.getAssemblyAccess().getGroup_4(), "rule__Assembly__Group_4__0");
					put(grammarAccess.getResourceAccess().getGroup(), "rule__Resource__Group__0");
					put(grammarAccess.getResourceAccess().getGroup_3(), "rule__Resource__Group_3__0");
					put(grammarAccess.getNQAAccess().getGroup(), "rule__NQA__Group__0");
					put(grammarAccess.getReasoningAccess().getGroup(), "rule__Reasoning__Group__0");
					put(grammarAccess.getReasoningAccess().getGroup_5(), "rule__Reasoning__Group_5__0");
					put(grammarAccess.getRuleAccess().getGroup(), "rule__Rule__Group__0");
					put(grammarAccess.getRuleAccess().getGroup_3(), "rule__Rule__Group_3__0");
					put(grammarAccess.getRuleAccess().getGroup_6(), "rule__Rule__Group_6__0");
					put(grammarAccess.getEntryAccess().getGroup(), "rule__Entry__Group__0");
					put(grammarAccess.getEntryAccess().getGroup_3(), "rule__Entry__Group_3__0");
					put(grammarAccess.getNumericValueAccess().getGroup(), "rule__NumericValue__Group__0");
					put(grammarAccess.getModelAccess().getSpecificationsAssignment_0(), "rule__Model__SpecificationsAssignment_0");
					put(grammarAccess.getModelAccess().getSpecificationsAssignment_1_1(), "rule__Model__SpecificationsAssignment_1_1");
					put(grammarAccess.getQualityEffectSpecificationAccess().getComponentsAssignment_2(), "rule__QualityEffectSpecification__ComponentsAssignment_2");
					put(grammarAccess.getQualityEffectSpecificationAccess().getComponentsAssignment_3_1(), "rule__QualityEffectSpecification__ComponentsAssignment_3_1");
					put(grammarAccess.getQualityEffectSpecificationAccess().getTransformationsAssignment_7(), "rule__QualityEffectSpecification__TransformationsAssignment_7");
					put(grammarAccess.getQualityEffectSpecificationAccess().getTransformationsAssignment_8_1(), "rule__QualityEffectSpecification__TransformationsAssignment_8_1");
					put(grammarAccess.getComponentSpecificationAccess().getPropertiesAssignment_2(), "rule__ComponentSpecification__PropertiesAssignment_2");
					put(grammarAccess.getComponentSpecificationAccess().getPropertiesAssignment_3_1(), "rule__ComponentSpecification__PropertiesAssignment_3_1");
					put(grammarAccess.getNameAccess().getNotAssignment_2(), "rule__Name__NotAssignment_2");
					put(grammarAccess.getNameAccess().getAutonymAssignment_3(), "rule__Name__AutonymAssignment_3");
					put(grammarAccess.getIdentifierAccess().getNotAssignment_2(), "rule__Identifier__NotAssignment_2");
					put(grammarAccess.getIdentifierAccess().getIdAssignment_3(), "rule__Identifier__IdAssignment_3");
					put(grammarAccess.getAnnotationAccess().getNotAssignment_2(), "rule__Annotation__NotAssignment_2");
					put(grammarAccess.getAnnotationAccess().getAnnotationAssignment_3(), "rule__Annotation__AnnotationAssignment_3");
					put(grammarAccess.getTypeAccess().getNotAssignment_2(), "rule__Type__NotAssignment_2");
					put(grammarAccess.getTypeAccess().getTypeAssignment_3(), "rule__Type__TypeAssignment_3");
					put(grammarAccess.getRoleAccess().getNotAssignment_2(), "rule__Role__NotAssignment_2");
					put(grammarAccess.getRoleAccess().getTypeAssignment_3(), "rule__Role__TypeAssignment_3");
					put(grammarAccess.getRoleAccess().getPropertiesAssignment_4_1(), "rule__Role__PropertiesAssignment_4_1");
					put(grammarAccess.getRoleAccess().getPropertiesAssignment_4_2_1(), "rule__Role__PropertiesAssignment_4_2_1");
					put(grammarAccess.getAssemblyAccess().getNotAssignment_2(), "rule__Assembly__NotAssignment_2");
					put(grammarAccess.getAssemblyAccess().getTypeAssignment_3(), "rule__Assembly__TypeAssignment_3");
					put(grammarAccess.getAssemblyAccess().getComponentAssignment_4_1(), "rule__Assembly__ComponentAssignment_4_1");
					put(grammarAccess.getResourceAccess().getPropertiesAssignment_2(), "rule__Resource__PropertiesAssignment_2");
					put(grammarAccess.getResourceAccess().getPropertiesAssignment_3_1(), "rule__Resource__PropertiesAssignment_3_1");
					put(grammarAccess.getNQAAccess().getQualityAssignment_2(), "rule__NQA__QualityAssignment_2");
					put(grammarAccess.getNQAAccess().getTypeAssignment_3(), "rule__NQA__TypeAssignment_3");
					put(grammarAccess.getNQAAccess().getElementAssignment_4(), "rule__NQA__ElementAssignment_4");
					put(grammarAccess.getReasoningAccess().getQualityAssignment_2(), "rule__Reasoning__QualityAssignment_2");
					put(grammarAccess.getReasoningAccess().getRulesAssignment_4(), "rule__Reasoning__RulesAssignment_4");
					put(grammarAccess.getReasoningAccess().getRulesAssignment_5_1(), "rule__Reasoning__RulesAssignment_5_1");
					put(grammarAccess.getRuleAccess().getQualitiesAssignment_2(), "rule__Rule__QualitiesAssignment_2");
					put(grammarAccess.getRuleAccess().getQualitiesAssignment_3_1(), "rule__Rule__QualitiesAssignment_3_1");
					put(grammarAccess.getRuleAccess().getEntriesAssignment_5(), "rule__Rule__EntriesAssignment_5");
					put(grammarAccess.getRuleAccess().getEntriesAssignment_6_1(), "rule__Rule__EntriesAssignment_6_1");
					put(grammarAccess.getEntryAccess().getKeyAssignment_2(), "rule__Entry__KeyAssignment_2");
					put(grammarAccess.getEntryAccess().getKeyAssignment_3_1(), "rule__Entry__KeyAssignment_3_1");
					put(grammarAccess.getEntryAccess().getValueAssignment_5(), "rule__Entry__ValueAssignment_5");
					put(grammarAccess.getNumericValueAccess().getValueTypeAssignment_0(), "rule__NumericValue__ValueTypeAssignment_0");
					put(grammarAccess.getNumericValueAccess().getTransformationTypeAssignment_2(), "rule__NumericValue__TransformationTypeAssignment_2");
					put(grammarAccess.getNumericValueAccess().getTransformationNumberAssignment_3(), "rule__NumericValue__TransformationNumberAssignment_3");
				}
			};
		}
		return nameMappings.get(element);
	}
			
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public QualityEffectSpecificationGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(QualityEffectSpecificationGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
