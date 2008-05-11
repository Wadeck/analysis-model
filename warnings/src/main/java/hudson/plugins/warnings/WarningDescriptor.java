package hudson.plugins.warnings;

import hudson.model.AbstractProject;
import hudson.plugins.warnings.util.PluginDescriptor;

import org.kohsuke.stapler.StaplerRequest;

/**
 * Descriptor for the class {@link WarningPublisher}. Used as a singleton. The
 * class is marked as public so that it can be accessed from views.
 *
 * @author Ulli Hafner
 */
public final class WarningDescriptor extends PluginDescriptor {
    /** Plug-in name. */
    private static final String PLUGIN_NAME = "warnings";
    /** Icon to use for the result and project action. */
    private static final String ACTION_ICON = "/plugin/warnings/icons/warnings-24x24.png";

    /**
     * Instantiates a new find bugs descriptor.
     */
    WarningDescriptor() {
        super(WarningPublisher.class);
    }

    /** {@inheritDoc} */
    @Override
    public String getDisplayName() {
        return Messages.Warnings_Publisher_Name();
    }

    /** {@inheritDoc} */
    @Override
    public String getPluginName() {
        return PLUGIN_NAME;
    }

    /** {@inheritDoc} */
    @Override
    public String getIconUrl() {
        return ACTION_ICON;
    }

    /** {@inheritDoc} */
    @Override
    public WarningPublisher newInstance(final StaplerRequest request) throws FormException {
        return request.bindParameters(WarningPublisher.class, PLUGIN_NAME + "_");
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public boolean isApplicable(final Class<? extends AbstractProject> jobType) {
        return true;
    }
}