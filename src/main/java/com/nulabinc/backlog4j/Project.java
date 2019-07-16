package com.nulabinc.backlog4j;

/**
 * The interface for Backlog project data.
 *
 * @author nulab-inc
 */
public interface Project {

    enum TextFormattingRule {
        Markdown("markdown"), Backlog("backlog");

        TextFormattingRule(String value) {
            this.value = value;
        }

        public String getStrValue() {
            return value;
        }

        public static TextFormattingRule enumValueOf(final String anValue) {
            for (TextFormattingRule d : values()) {
                if (d.getStrValue().equals(anValue)) {
                    return d;
                }
            }
            return null;
        }

        private String value;
    }

    enum IssueTypeColor {
        Color1("#e30000"),
        Color2("#990000"),
        Color3("#934981"),
        Color4("#814fbc"),
        Color5("#2779ca"),
        Color6("#007e9a"),
        Color7("#7ea800"),
        Color8("#ff9200"),
        Color9("#ff3265"),
        Color10("#666665");

        IssueTypeColor(String value) {
            this.value = value;
        }

        public String getStrValue() {
            return value;
        }

        public static IssueTypeColor strValueOf(final String anValue) {
            for (IssueTypeColor d : values()) {
                if (d.getStrValue().equals(anValue)) {
                    return d;
                }
            }
            return null;
        }

        private String value;
    }

    enum CustomStatusColor {
        Color1("#ed8077"),
        Color2("#4488c5"),
        Color3("#5eb5a6"),
        Color4("#b0be3c"),
        Color5("#ea2c00"),
        Color6("#e87758"),
        Color7("#e07b9a"),
        Color8("#868cb7"),
        Color9("#3b9dbd"),
        Color10("#4caf93"),
        Color11("#b0be3c"),
        Color12("#eda62a"),
        Color13("#f42858"),
        Color14("#393939");

        CustomStatusColor(String value) {
            this.value = value;
        }

        public String getStrValue() {
            return value;
        }

        public static CustomStatusColor strValueOf(final String anValue) {
            for (CustomStatusColor d : values()) {
                if (d.getStrValue().equals(anValue)) {
                    return d;
                }
            }
            return null;
        }

        private String value;
    }

    long getId();

    String getIdAsString();

    String getProjectKey();

    String getName();

    boolean isChartEnabled();

    boolean isSubtaskingEnabled();

    TextFormattingRule getTextFormattingRule();

    boolean isArchived();

    long getDisplayOrder();
}
