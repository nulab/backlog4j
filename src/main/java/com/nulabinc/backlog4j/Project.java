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
        Color1("#ea2c00"),
        Color2("#e87758"),
        Color3("#e07b9a"),
        Color4("#868cb7"),
        Color5("#3b9dbd"),
        Color6("#4caf93"),
        Color7("#b0be3c"),
        Color8("#eda62a"),
        Color9("#f42858"),
        Color10("#393939");

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

    boolean useDevAttributes();
}
