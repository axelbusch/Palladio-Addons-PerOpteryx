package edu.kit.ipd.are.dsexplore.analysis.sec;

import org.apache.log4j.Logger;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

public class SecurityAnalysisTabGroup extends AbstractLaunchConfigurationTabGroup {

	static Logger logger = Logger.getLogger(SecurityAnalysisTabGroup.class);

	@Override
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
		logger.debug("Hi from createTabs");
		ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[] {
				new SecurityAnalysisTab()
		};
		this.setTabs(tabs);
	}
}
