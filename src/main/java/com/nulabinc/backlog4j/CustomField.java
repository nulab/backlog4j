package com.nulabinc.backlog4j;

/**
 * The interface for Backlog custom filed data.
 *
 * @author nulab-inc
 */
public interface CustomField {
    enum FieldType {
        Text(1), TextArea(2), Numeric(3), Date(4), SingleList(5), MultipleList(6), CheckBox(7), Radio(8);

        FieldType(int intValue) {
            this.intValue = intValue;
        }

        public int getIntValue() {
            return intValue;
        }

        public static FieldType valueOf(final int anIntValue) {
            for (FieldType d : values()) {
                if (d.getIntValue() == anIntValue) {
                    return d;
                }
            }
            return null;
        }

        private int intValue;
    }

    long getId();

    String getIdAsString();

    String getName();

    int getFieldTypeId();

    FieldType getFieldType();
}
