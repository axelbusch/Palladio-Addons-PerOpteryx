package de.uka.ipd.sdq.dsexplore.analysis.simulizar.ui.configuration;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.palladiosimulator.simulizar.launcher.SimulizarConstants;
import de.uka.ipd.sdq.workflow.launchconfig.LaunchConfigPlugin;
import de.uka.ipd.sdq.workflow.launchconfig.tabs.TabHelper;
import de.uka.ipd.sdq.workflow.pcm.runconfig.ProtocomFileNamesInputTab;

public class InterpreterFileNamesInputTab extends ProtocomFileNamesInputTab {
	// input fields
			/** Text field for path to pms file. */
			protected Text pmsFile;
			/** Text field for path to event sdm file folder. */
			protected Text reconfigurationRulesFolder;
			/**
			 * @see de.uka.ipd.sdq.workflow.launchconfig.tabs.FileNamesInputTab#createControl(org.eclipse.swt.widgets.Composite)
			 */
			@Override
			public void createControl(final Composite parent) {
				super.createControl(parent);
				modifyListener = new ModifyListener() {
					public void modifyText(ModifyEvent e) {
						setDirty(true);
						updateLaunchConfigurationDialog();
					}
				};
				container = new Composite(parent, SWT.NONE);
				setControl(container);
				container.setLayout(new GridLayout()); 
				/**
				 * Create PMS file section
				 */
				pmsFile = new Text(container, SWT.SINGLE | SWT.BORDER);
				TabHelper.createFileInputSection(container, modifyListener, "Optional: Palladio Monitoring Specification Model (PMS) File", SimulizarConstants.MONITORING_SPECIFICATION_FILE_EXTENSION, pmsFile, "Select PMS File", getShell(), SimulizarConstants.DEFAULT_PMS_FILE);
				/**
				 * Create SDM folder section
				 */
				reconfigurationRulesFolder = new Text(container, SWT.SINGLE | SWT.BORDER);
				TabHelper.createFolderInputSection(container, modifyListener, "Optional: Reconfiguration rules folder ", reconfigurationRulesFolder, "Select Reconfiguration Rules Folder", getShell(), SimulizarConstants.DEFAULT_RECONFIGURATION_RULES_FOLDER);
			}

			/**
			 * @see de.uka.ipd.sdq.workflow.launchconfig.tabs.FileNamesInputTab#initializeFrom(org.eclipse.debug.core.ILaunchConfiguration)
			 */
			@Override
			public void initializeFrom(final ILaunchConfiguration configuration) {
				super.initializeFrom(configuration);
				try {
					pmsFile.setText(configuration.getAttribute(
							SimulizarConstants.PMS_FILE, SimulizarConstants.DEFAULT_PMS_FILE));
				} catch (CoreException e) {
					LaunchConfigPlugin.errorLogger(getName(),"PMS File", e.getMessage());
				}

				try {
					reconfigurationRulesFolder.setText(configuration.getAttribute(
							SimulizarConstants.RECONFIGURATION_RULES_FOLDER, SimulizarConstants.DEFAULT_RECONFIGURATION_RULES_FOLDER));
				} catch (CoreException e) {
					LaunchConfigPlugin.errorLogger(getName(),"Reconfiguration Rules Folder", e.getMessage());
				}

			}

			/* (non-Javadoc)
			 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#performApply(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
			 */
			public void performApply(ILaunchConfigurationWorkingCopy configuration) {
				super.performApply(configuration);
				configuration.setAttribute(SimulizarConstants.PMS_FILE,
						pmsFile.getText());
				configuration.setAttribute(SimulizarConstants.RECONFIGURATION_RULES_FOLDER, reconfigurationRulesFolder.getText());
			}	
			
			/* (non-Javadoc)
			 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#setDefaults(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
			 */
			public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
				super.setDefaults(configuration);
				configuration.setAttribute(SimulizarConstants.PMS_FILE,	SimulizarConstants.DEFAULT_PMS_FILE);
				configuration.setAttribute(SimulizarConstants.RECONFIGURATION_RULES_FOLDER, SimulizarConstants.DEFAULT_RECONFIGURATION_RULES_FOLDER);
			}
			
			public String getName() {
				return "SimuLizar Model(s)";
			}
			
			/**
			 * @see de.uka.ipd.sdq.workflow.launchconfig.tabs.FileNamesInputTab#isValid(org.eclipse.debug.core.ILaunchConfiguration)
			 */
			@Override
			public boolean isValid(final ILaunchConfiguration launchConfig) {
				return true;
			}
}