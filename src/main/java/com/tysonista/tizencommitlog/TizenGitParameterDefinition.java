package com.tysonista.tizencommitlog;

import hudson.Extension;
import hudson.model.ParameterValue;
import hudson.model.ParameterDefinition;
import hudson.util.FormValidation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.sf.json.JSONObject;

import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.QueryParameter;
import org.kohsuke.stapler.StaplerRequest;

public class TizenGitParameterDefinition extends ParameterDefinition {

    public final String gitUrl;
    public final String gitPort;
    public final String gitPath;
    public final String gitBranch;

    @DataBoundConstructor
    public TizenGitParameterDefinition(String name, String description, String gitUrl, String gitPort, String gitPath, String gitBranch) {
        super(name, description);
        this.gitUrl=gitUrl;
        this.gitPort=gitPort;
        this.gitPath=gitPath;
        this.gitBranch=gitBranch;
    }

    public final List<Object> getGitUrls() {
        ArrayList<Object> list = new ArrayList<Object>();
        list.addAll(Arrays.asList(this.gitUrl.split("\n")));
        return list;
    }

    public final List<Object> getGitPorts() {
        ArrayList<Object> list = new ArrayList<Object>();
        list.addAll(Arrays.asList(this.gitPort.split("\n")));
        return list;
    }

    public final List<Object> getGitPaths() {
        ArrayList<Object> list = new ArrayList<Object>();
        list.addAll(Arrays.asList(this.gitPath.split("\n")));
        return list;
    }

    public final List<Object> getGitBranchs() {
        ArrayList<Object> list = new ArrayList<Object>();
        list.addAll(Arrays.asList(this.gitBranch.split("\n")));
        return list;
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
        public FormValidation doTest(
                @QueryParameter("url") String url,
                @QueryParameter("port") String port,
                @QueryParameter("path") String path,
                @QueryParameter("branch") String branch) {
            return FormValidation.ok("gitUrl:"+url+
                    ", gitPort:"+port+
                    ", gitPath:"+path+
                    ", gitBranch:"+branch);
        }
    }
}
