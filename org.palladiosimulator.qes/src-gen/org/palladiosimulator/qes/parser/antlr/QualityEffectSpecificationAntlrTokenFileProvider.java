/*
 * generated by Xtext 2.14.0
 */
package org.palladiosimulator.qes.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class QualityEffectSpecificationAntlrTokenFileProvider implements IAntlrTokenFileProvider {

	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream("org/palladiosimulator/qes/parser/antlr/internal/InternalQualityEffectSpecification.tokens");
	}
}
