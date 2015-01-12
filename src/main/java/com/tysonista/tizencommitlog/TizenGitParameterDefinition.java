package com.tysonista.tizencommitlog;

import net.sf.json.JSONObject;

import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.QueryParameter;
import org.kohsuke.stapler.StaplerRequest;

import hudson.Extension;
import hudson.model.ParameterValue;
import hudson.model.ParameterDefinition;
import hudson.model.ParameterDefinition.ParameterDescriptor;
import hudson.util.FormValidation;

public class TizenGitParameterDefinition extends ParameterDefinition {

    @DataBoundConstructor
    public TizenGitParameterDefinition(String name) {
        super(name);
        // TODO Auto-generated constructor stub
    }

    /**
     * 
     */
    private static final long serialVersionUID = -730014143015177976L;

    @Override
    public ParameterValue createValue(StaplerRequest arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ParameterValue createValue(StaplerRequest arg0, JSONObject arg1) {
        // TODO Auto-generated method stub
        return null;
    }

    @Extension
    public static class DescriptorImpl extends ParameterDescriptor {
        @Override
        public String getDisplayName() {
            return "Tizen Commit Logs";
        }
        public FormValidation doGetCommitLog(
                @QueryParameter String gitUrl,
                @QueryParameter String gitPort,
                @QueryParameter String gitPath,
                @QueryParameter String gitBranch,
                @QueryParameter String packageVersionRule
                ) {
                    return FormValidation.ok("button clicked.");
            
        }
    }
}
