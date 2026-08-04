package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.DocumentTree;
import com.nulabinc.backlog4j.DocumentTreeNode;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author nulab-inc
 */
public class DocumentTreeJSONImplTest extends AbstractJSONImplTest {
    @Test
    public void createDocumentTreeTest() throws IOException {
        String fileContentStr = getJsonString("json/document_tree.json");
        DocumentTree documentTree = factory.createDocumentTree(fileContentStr);

        assertEquals(1073835211, documentTree.getProjectId());

        DocumentTreeNode activeTree = documentTree.getActiveTree();
        assertEquals("Active", activeTree.getId());
        assertEquals(1, activeTree.getChildren().size());

        DocumentTreeNode document = activeTree.getChildren().get(0);
        assertEquals("1234567890abcdef", document.getId());
        assertEquals("Getting Started", document.getName());
        assertEquals("🚀", document.getEmoji());
        assertEquals(1, document.getChildren().size());

        DocumentTreeNode childDocument = document.getChildren().get(0);
        assertEquals("abcdef1234567890", childDocument.getId());
        assertEquals("Setup", childDocument.getName());
        assertNull(childDocument.getEmoji());
        // "children" key is omitted for this node in the fixture, exercising the missing-key path
        assertTrue(childDocument.getChildren().isEmpty());

        DocumentTreeNode trashTree = documentTree.getTrashTree();
        assertEquals("Trash", trashTree.getId());
        assertTrue(trashTree.getChildren().isEmpty());
    }

    @Test
    public void equalsTest() throws IOException {
        String fileContentStr = getJsonString("json/document_tree.json");
        DocumentTree documentTree1 = factory.createDocumentTree(fileContentStr);
        DocumentTree documentTree2 = factory.createDocumentTree(fileContentStr);
        assertEquals(documentTree1, documentTree2);
    }

    @Test
    public void hashCodeTest() throws IOException {
        String fileContentStr = getJsonString("json/document_tree.json");
        DocumentTree documentTree1 = factory.createDocumentTree(fileContentStr);
        DocumentTree documentTree2 = factory.createDocumentTree(fileContentStr);
        assertEquals(documentTree1.hashCode(), documentTree2.hashCode());
    }
}
