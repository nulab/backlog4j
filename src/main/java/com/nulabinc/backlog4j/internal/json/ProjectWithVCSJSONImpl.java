package com.nulabinc.backlog4j.internal.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nulabinc.backlog4j.ProjectWithVCS;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectWithVCSJSONImpl extends ProjectJSONImpl implements ProjectWithVCS {
    private boolean useSubversion;
    private boolean useGit;

    @Override
    public boolean getUseSubversion() {
        return useSubversion;
    }

    @Override
    public boolean getUseGit() {
        return useGit;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        ProjectWithVCSJSONImpl rhs = (ProjectWithVCSJSONImpl) obj;
        return super.createEqualsBuilder(rhs)
                .append(this.useSubversion, rhs.useSubversion)
                .append(this.useGit, rhs.useGit)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return super.createHashCodeBuilder()
                .append(useSubversion)
                .append(useGit)
                .toHashCode();
    }

    @Override
    public String toString() {
        return super.createToStringBuilder()
                .append("useSubversion", useSubversion)
                .append("useGit", useGit)
                .toString();
    }
}
