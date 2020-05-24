package com.viartemev.requestmapper

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiAnnotation
import com.intellij.psi.search.GlobalSearchScope.projectScope
import org.jetbrains.kotlin.asJava.toLightAnnotation
import org.jetbrains.kotlin.idea.stubindex.KotlinAnnotationsIndex

object KotlinAnnotationSearcher {

    fun search(annotationName: String, project: Project): Sequence<PsiAnnotation> {
        return KotlinAnnotationsIndex
            .getInstance()
            .get(annotationName, project, projectScope(project))
            .asSequence()
            .mapNotNull { it.toLightAnnotation() }
    }
}