package com.nulabinc.backlog4j;

/**
 * The interface for Backlog user data.
 *
 * @author nulab-inc
 */
public interface User {
    enum RoleType {
        Admin(1), User(2), Reporter(3), Viewer(4), GuestReporter(5), GuestViewer(6);

        RoleType(int intValue) {
            this.intValue = intValue;
        }

        public int getIntValue() {
            return intValue;
        }

        public static RoleType valueOf(final int anIntValue) {
            for (RoleType d : values()) {
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

    String getUserId();

    RoleType getRoleType();

    String getLang();

    String getMailAddress();
}
