package com.github.plaskowski.findimmutablesusagesplugin.services

import com.github.plaskowski.findimmutablesusagesplugin.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
