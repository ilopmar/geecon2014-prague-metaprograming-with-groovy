package geecon2014

import org.codehaus.groovy.ast.ASTNode
import org.codehaus.groovy.ast.AnnotationNode
import org.codehaus.groovy.ast.ClassHelper
import org.codehaus.groovy.ast.ClassNode
import org.codehaus.groovy.ast.expr.ConstantExpression
import org.codehaus.groovy.control.CompilePhase
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.syntax.SyntaxException
import org.codehaus.groovy.transform.AbstractASTTransformation
import org.codehaus.groovy.transform.GroovyASTTransformation

@GroovyASTTransformation(phase = CompilePhase.SEMANTIC_ANALYSIS)
class VersionASTTransformation extends AbstractASTTransformation {

    @Override
    public void visit(final ASTNode[] nodes, final SourceUnit source) {
        if (nodes.length != 2) {
            return
        }

        if (nodes[0] instanceof AnnotationNode && nodes[1] instanceof ClassNode) {
            def annotation = nodes[0]
            def version = annotation.getMember('value')

            if (version instanceof ConstantExpression) {
                nodes[1].addField('VERSION', ACC_PUBLIC | ACC_STATIC | ACC_FINAL, ClassHelper.STRING_TYPE, version)
            } else {
                source.addError(new SyntaxException("Invalid value for annotation", annotation.lineNumber, annotation.columnNumber))
            }
        }
    }
}