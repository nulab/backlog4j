package com.nulabinc.backlog4j;

public interface ProjectWithVCS extends Project {
    boolean getUseSubversion();

    boolean getUseGit();
}
