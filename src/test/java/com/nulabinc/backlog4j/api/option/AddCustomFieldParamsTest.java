package com.nulabinc.backlog4j.api.option;

import com.nulabinc.backlog4j.internal.json.customFields.DateCustomFieldSetting;
import org.apache.http.NameValuePair;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author nulab-inc
 */
public class AddCustomFieldParamsTest {

    @Test
    public void AddTextCustomFieldParamsTest() {

        // when
        AddTextCustomFieldParams params = new AddTextCustomFieldParams(
                "PRJ", "TextCustomField");
        params.description("TextCustomFieldです").required(true);

        // then
        List<NameValuePair> parameters = params.getParamList();
        assertEquals(4, parameters.size());

        NameValuePair pair = parameters.get(0);
        assertEquals("typeId", pair.getName());
        assertEquals("1", pair.getValue());

        pair = parameters.get(1);
        assertEquals("name", pair.getName());
        assertEquals("TextCustomField", pair.getValue());

        pair = parameters.get(2);
        assertEquals("description", pair.getName());
        assertEquals("TextCustomFieldです", pair.getValue());

        pair = parameters.get(3);
        assertEquals("required", pair.getName());
        assertEquals("true", pair.getValue());


    }

    @Test
    public void AddTextAreaCustomFieldParamsTest() {

        // when
        AddTextAreaCustomFieldParams params = new AddTextAreaCustomFieldParams(
                "PRJ", "TextAreaCustomField");
        params.description("TextCustomFieldです").required(true);

        // then
        List<NameValuePair> parameters = params.getParamList();
        assertEquals(4, parameters.size());

        NameValuePair pair = parameters.get(0);
        assertEquals("typeId", pair.getName());
        assertEquals("2", pair.getValue());

        pair = parameters.get(1);
        assertEquals("name", pair.getName());
        assertEquals("TextAreaCustomField", pair.getValue());

        pair = parameters.get(2);
        assertEquals("description", pair.getName());
        assertEquals("TextCustomFieldです", pair.getValue());

        pair = parameters.get(3);
        assertEquals("required", pair.getName());
        assertEquals("true", pair.getValue());


    }

    @Test
    public void AddNumericCustomFieldParamsTest() {
        // when
        AddNumericCustomFieldParams params = new AddNumericCustomFieldParams(
                "PRJ", "NumericCustomField");
        params.description("TextCustomFieldです").required(true).min(10).max(121212l).initialValue(21);

        // then
        List<NameValuePair> parameters = params.getParamList();
        assertEquals(7, parameters.size());

        NameValuePair pair = parameters.get(0);
        assertEquals("typeId", pair.getName());
        assertEquals("3", pair.getValue());

        pair = parameters.get(1);
        assertEquals("name", pair.getName());
        assertEquals("NumericCustomField", pair.getValue());

        pair = parameters.get(2);
        assertEquals("description", pair.getName());
        assertEquals("TextCustomFieldです", pair.getValue());

        pair = parameters.get(3);
        assertEquals("required", pair.getName());
        assertEquals("true", pair.getValue());

        pair = parameters.get(4);
        assertEquals("min", pair.getName());
        assertEquals("10.0", pair.getValue());

        pair = parameters.get(5);
        assertEquals("max", pair.getName());
        assertEquals("121212.0", pair.getValue());

        pair = parameters.get(6);
        assertEquals("initialValue", pair.getName());
        assertEquals("21.0", pair.getValue());
    }

    @Test
    public void AddDateCustomFieldParamsTest() {
        // when
        AddDateCustomFieldParams params = new AddDateCustomFieldParams(
                "PRJ", "DateCustomField");
        params.description("DateCustomFieldです").required(true)
                .initialValueType(DateCustomFieldSetting.InitialValueType.TodayPlusShiftDays)
                .initialShift(2);

        // then
        List<NameValuePair> parameters = params.getParamList();
        assertEquals(6, parameters.size());

        NameValuePair pair = parameters.get(0);
        assertEquals("typeId", pair.getName());
        assertEquals("4", pair.getValue());

        pair = parameters.get(1);
        assertEquals("name", pair.getName());
        assertEquals("DateCustomField", pair.getValue());

        pair = parameters.get(2);
        assertEquals("description", pair.getName());
        assertEquals("DateCustomFieldです", pair.getValue());

        pair = parameters.get(3);
        assertEquals("required", pair.getName());
        assertEquals("true", pair.getValue());

        pair = parameters.get(4);
        assertEquals("initialValueType", pair.getName());
        assertEquals("2", pair.getValue());

        pair = parameters.get(5);
        assertEquals("initialShift", pair.getName());
        assertEquals("2", pair.getValue());
    }

    @Test
    public void AddSingleListCustomFieldParamsTest() {
        // when
        AddSingleListCustomFieldParams params = new AddSingleListCustomFieldParams(
                "PRJ", "SingleListCustomField");
        params.description("SingleListCustomFieldです").required(true)
                .allowInput(false)
                .allowAddItem(true)
                .items(Arrays.asList("卵","牛乳","みかん"));

        // then
        List<NameValuePair> parameters = params.getParamList();
        assertEquals(9, parameters.size());

        NameValuePair pair = parameters.get(0);
        assertEquals("typeId", pair.getName());
        assertEquals("5", pair.getValue());

        pair = parameters.get(1);
        assertEquals("name", pair.getName());
        assertEquals("SingleListCustomField", pair.getValue());

        pair = parameters.get(2);
        assertEquals("description", pair.getName());
        assertEquals("SingleListCustomFieldです", pair.getValue());

        pair = parameters.get(3);
        assertEquals("required", pair.getName());
        assertEquals("true", pair.getValue());

        pair = parameters.get(4);
        assertEquals("allowInput", pair.getName());
        assertEquals("false", pair.getValue());

        pair = parameters.get(5);
        assertEquals("allowAddItem", pair.getName());
        assertEquals("true", pair.getValue());

        pair = parameters.get(6);
        assertEquals("items[]", pair.getName());
        assertEquals("卵", pair.getValue());

        pair = parameters.get(7);
        assertEquals("items[]", pair.getName());
        assertEquals("牛乳", pair.getValue());

        pair = parameters.get(8);
        assertEquals("items[]", pair.getName());
        assertEquals("みかん", pair.getValue());

    }

    @Test
    public void AddMultipleListCustomFieldParamsTest() {
        // when
        AddMultipleListCustomFieldParams params = new AddMultipleListCustomFieldParams(
                "PRJ", "MultipleListCustomField");
        params.description("MultipleListCustomFieldです").required(true)
                .allowInput(false)
                .allowAddItem(true)
                .items(Arrays.asList("卵","牛乳","みかん"));

        // then
        List<NameValuePair> parameters = params.getParamList();
        assertEquals(9, parameters.size());

        NameValuePair pair = parameters.get(0);
        assertEquals("typeId", pair.getName());
        assertEquals("6", pair.getValue());

        pair = parameters.get(1);
        assertEquals("name", pair.getName());
        assertEquals("MultipleListCustomField", pair.getValue());

        pair = parameters.get(2);
        assertEquals("description", pair.getName());
        assertEquals("MultipleListCustomFieldです", pair.getValue());

        pair = parameters.get(3);
        assertEquals("required", pair.getName());
        assertEquals("true", pair.getValue());

        pair = parameters.get(4);
        assertEquals("allowInput", pair.getName());
        assertEquals("false", pair.getValue());

        pair = parameters.get(5);
        assertEquals("allowAddItem", pair.getName());
        assertEquals("true", pair.getValue());

        pair = parameters.get(6);
        assertEquals("items[]", pair.getName());
        assertEquals("卵", pair.getValue());

        pair = parameters.get(7);
        assertEquals("items[]", pair.getName());
        assertEquals("牛乳", pair.getValue());

        pair = parameters.get(8);
        assertEquals("items[]", pair.getName());
        assertEquals("みかん", pair.getValue());

    }

    @Test
    public void AddCheckBoxCustomFieldParamsTest() {
        // when
        AddCheckBoxCustomFieldParams params = new AddCheckBoxCustomFieldParams(
                "PRJ", "CheckBoxCustomField");
        params.description("CheckBoxCustomFieldです").required(true)
                .allowInput(false)
                .allowAddItem(true)
                .items(Arrays.asList("卵","牛乳","みかん"));

        // then
        List<NameValuePair> parameters = params.getParamList();
        assertEquals(9, parameters.size());

        NameValuePair pair = parameters.get(0);
        assertEquals("typeId", pair.getName());
        assertEquals("7", pair.getValue());

        pair = parameters.get(1);
        assertEquals("name", pair.getName());
        assertEquals("CheckBoxCustomField", pair.getValue());

        pair = parameters.get(2);
        assertEquals("description", pair.getName());
        assertEquals("CheckBoxCustomFieldです", pair.getValue());

        pair = parameters.get(3);
        assertEquals("required", pair.getName());
        assertEquals("true", pair.getValue());

        pair = parameters.get(4);
        assertEquals("allowInput", pair.getName());
        assertEquals("false", pair.getValue());

        pair = parameters.get(5);
        assertEquals("allowAddItem", pair.getName());
        assertEquals("true", pair.getValue());

        pair = parameters.get(6);
        assertEquals("items[]", pair.getName());
        assertEquals("卵", pair.getValue());

        pair = parameters.get(7);
        assertEquals("items[]", pair.getName());
        assertEquals("牛乳", pair.getValue());

        pair = parameters.get(8);
        assertEquals("items[]", pair.getName());
        assertEquals("みかん", pair.getValue());

    }

    @Test
    public void AddRadioCustomFieldParamsTest() {
        // when
        AddRadioCustomFieldParams params = new AddRadioCustomFieldParams(
                "PRJ", "RadioCustomField");
        params.description("RadioCustomFieldです").required(true)
                .allowInput(false)
                .allowAddItem(true)
                .items(Arrays.asList("卵","牛乳","みかん"));

        // then
        List<NameValuePair> parameters = params.getParamList();
        assertEquals(9, parameters.size());

        NameValuePair pair = parameters.get(0);
        assertEquals("typeId", pair.getName());
        assertEquals("8", pair.getValue());

        pair = parameters.get(1);
        assertEquals("name", pair.getName());
        assertEquals("RadioCustomField", pair.getValue());

        pair = parameters.get(2);
        assertEquals("description", pair.getName());
        assertEquals("RadioCustomFieldです", pair.getValue());

        pair = parameters.get(3);
        assertEquals("required", pair.getName());
        assertEquals("true", pair.getValue());

        pair = parameters.get(4);
        assertEquals("allowInput", pair.getName());
        assertEquals("false", pair.getValue());

        pair = parameters.get(5);
        assertEquals("allowAddItem", pair.getName());
        assertEquals("true", pair.getValue());

        pair = parameters.get(6);
        assertEquals("items[]", pair.getName());
        assertEquals("卵", pair.getValue());

        pair = parameters.get(7);
        assertEquals("items[]", pair.getName());
        assertEquals("牛乳", pair.getValue());

        pair = parameters.get(8);
        assertEquals("items[]", pair.getName());
        assertEquals("みかん", pair.getValue());

    }
}
