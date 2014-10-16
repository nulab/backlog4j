package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.Activity;
import com.nulabinc.backlog4j.Category;
import com.nulabinc.backlog4j.ResponseList;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * @author nulab-inc
 */
public class CategoryJSONImplTest extends AbstractJSONImplTest{
    @Test
    public void createCategoryListTest() throws IOException {
        String fileContentStr = getJsonString("json/categories.json");
        ResponseList<Category> versions = factory.createCategoryList(fileContentStr);

        assertEquals(4, versions.size());

        Category version = versions.get(0);
        assertEquals(1073967643, version.getId());
        assertEquals("検討", version.getName());

        version = versions.get(1);
        assertEquals(1073967645, version.getId());
        assertEquals("障害", version.getName());

        version = versions.get(2);
        assertEquals(1073967646, version.getId());
        assertEquals("懸念", version.getName());

        version = versions.get(3);
        assertEquals(1073967647, version.getId());
        assertEquals("企画", version.getName());

    }

    @Test
    public void createCategoryTest() throws IOException {
        String fileContentStr = getJsonString("json/category.json");
        Category category = factory.createCategory(fileContentStr);

        assertEquals(1073967641, category.getId());
        assertEquals("検討", category.getName());
    }

    @Test
    public void equalsTest() throws IOException {
        String fileContentStr = getJsonString("json/category.json");
        Category category1 = factory.createCategory(fileContentStr);
        Category category2 = factory.createCategory(fileContentStr);
        assertEquals(category1, category2);

    }
}
