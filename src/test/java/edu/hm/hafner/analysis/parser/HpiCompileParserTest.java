package hudson.plugins.warnings.parser;

import static junit.framework.Assert.*;
import hudson.plugins.warnings.util.model.FileAnnotation;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import org.junit.Test;

/**
 * Tests the class {@link HpiCompileParser}.
 */
public class HpiCompileParserTest extends ParserTest {
    /**
     * Parses a file with two deprecation warnings.
     *
     * @throws IOException
     *      if the file could not be read
     */
    @Test
    public void parseDeprecation() throws IOException {
        Collection<FileAnnotation> warnings = new HpiCompileParser().parse(getStream("hpi.log"));

        assertEquals("Wrong number of warnings detected.", 2, warnings.size());

        Iterator<FileAnnotation> iterator = warnings.iterator();
        FileAnnotation annotation = iterator.next();
        checkWarning(annotation,
                42,
                "newInstance(org.kohsuke.stapler.StaplerRequest) in hudson.model.Descriptor has been deprecated",
                "C:/Build/Results/jobs/Maven/workspace/tasks/src/main/java/hudson/plugins/tasks/TasksReporterDescriptor.java",
                HpiCompileParser.WARNING_TYPE);
        annotation = iterator.next();
        checkWarning(annotation,
                47,
                "newInstance(org.kohsuke.stapler.StaplerRequest) in hudson.model.Descriptor has been deprecated",
                "C:/Build/Results/jobs/Maven/workspace/tasks/src/main/java/hudson/plugins/tasks/TasksDescriptor.java",
                HpiCompileParser.WARNING_TYPE);
    }
}

