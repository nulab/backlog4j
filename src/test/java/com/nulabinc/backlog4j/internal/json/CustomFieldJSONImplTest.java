package com.nulabinc.backlog4j.internal.json;

import com.nulabinc.backlog4j.Category;
import com.nulabinc.backlog4j.CustomFieldSetting;
import com.nulabinc.backlog4j.ResponseList;
import com.nulabinc.backlog4j.internal.json.customFields.*;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * @author nulab-inc
 */
public class CustomFieldJSONImplTest extends AbstractJSONImplTest{
    @Test
    public void createCustomFieldListTest() throws IOException {
        String fileContentStr = getJsonString("json/custom_fields.json");
        ResponseList<CustomFieldSetting> customFieldSettings = factory.createCustomFieldList(fileContentStr);

        assertEquals(4, customFieldSettings.size());
        CustomFieldSetting customFieldSetting = customFieldSettings.get(0);
        assertEquals(1073761530, customFieldSetting.getId());
        assert customFieldSetting instanceof TextCustomFieldSetting;

        System.out.println(customFieldSetting.getFieldTypeId());
/*
        customField = customFields.get(2);
        assertEquals(1073761531, customField.getId());
        assert customField instanceof Date;

        customField = customFields.get(3);
        assertEquals(1073761532, customField.getId());
        assert customField instanceof MultipleList;
        */

    }

    @Test
    public void createCustomFieldTest() throws IOException {
        String fileContentStr = getJsonString("json/custom_field.json");
        CustomFieldSetting customFieldSetting = factory.createCustomField(fileContentStr);


        assertEquals(1073761530, customFieldSetting.getId());

    }

    @Test
    public void equalsTest() throws IOException {
        String fileContentStr = getJsonString("json/custom_field.json");
        CustomFieldSetting customFieldSetting1 = factory.createCustomField(fileContentStr);
        CustomFieldSetting customFieldSetting2 = factory.createCustomField(fileContentStr);
        assertEquals(customFieldSetting1, customFieldSetting2);

    }
}
