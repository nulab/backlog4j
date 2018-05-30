package com.nulabinc.backlog4j;

import com.nulabinc.backlog4j.api.option.GetWikisParams;
import com.nulabinc.backlog4j.conf.BacklogJpConfigure;
import com.nulabinc.backlog4j.internal.json.ResponseListImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author nulab-inc
 */
public class BacklogClientImplTest {

    @Test
    public void wikiSortTest() {

        ResponseList<Wiki> result = new ResponseListImpl<Wiki>();
        Wiki wiki1 = new DummyWiki() {
            @Override
            public String getName() {
                return "ABC wiki";
            }

            @Override
            public Date getCreated() {
                return this.parseDate("2015-01-01 01:01:01");
            }

            @Override
            public Date getUpdated() {
                return this.parseDate("2015-10-10 01:01:03");
            }
        };
        Wiki wiki2 = new DummyWiki() {
            @Override
            public String getName() {
                return "XYZ wiki";
            }

            @Override
            public Date getCreated() {
                return this.parseDate("2015-01-01 01:01:02");
            }

            @Override
            public Date getUpdated() {
                return this.parseDate("2015-10-10 01:01:02");
            }
        };
        Wiki wiki3 = new DummyWiki() {
            @Override
            public String getName() {
                return "1230 wiki";
            }

            @Override
            public Date getCreated() {
                return this.parseDate("2015-04-01 01:01:01");
            }

            @Override
            public Date getUpdated() {
                return this.parseDate("2015-10-10 01:01:01");
            }
        };
        result.addAll(Arrays.asList(wiki1, wiki2, wiki3));
        BacklogClientImpl.sortWikis(result, GetWikisParams.SortKey.Name, GetWikisParams.Order.Asc);
        assertEquals(result.get(0), wiki3);
        assertEquals(result.get(1), wiki1);
        assertEquals(result.get(2), wiki2);
        BacklogClientImpl.sortWikis(result, GetWikisParams.SortKey.Name, GetWikisParams.Order.Desc);
        assertEquals(result.get(0), wiki2);
        assertEquals(result.get(1), wiki1);
        assertEquals(result.get(2), wiki3);
        BacklogClientImpl.sortWikis(result, GetWikisParams.SortKey.Created, GetWikisParams.Order.Asc);
        assertEquals(result.get(0), wiki1);
        assertEquals(result.get(1), wiki2);
        assertEquals(result.get(2), wiki3);
        BacklogClientImpl.sortWikis(result, GetWikisParams.SortKey.Created, GetWikisParams.Order.Desc);
        assertEquals(result.get(0), wiki3);
        assertEquals(result.get(1), wiki2);
        assertEquals(result.get(2), wiki1);
        BacklogClientImpl.sortWikis(result, GetWikisParams.SortKey.Updated, GetWikisParams.Order.Asc);
        assertEquals(result.get(0), wiki3);
        assertEquals(result.get(1), wiki2);
        assertEquals(result.get(2), wiki1);
        BacklogClientImpl.sortWikis(result, GetWikisParams.SortKey.Updated, GetWikisParams.Order.Desc);
        assertEquals(result.get(0), wiki1);
        assertEquals(result.get(1), wiki2);
        assertEquals(result.get(2), wiki3);
    }

    @Test
    public void getWikiUrlTest() throws MalformedURLException {
        BacklogClientImpl client = new BacklogClientImpl(new BacklogJpConfigure("test").apiKey("hogehoge"));
        Project project = new DummyProject() {
            @Override
            public String getProjectKey() {
                return "TEST_PROJECT";
            }
        };

        Wiki wiki = new DummyWiki() {
            @Override
            public String getName() {
                return "ABC wiki";
            }
        };
        String url = client.getWikiUrl(project, wiki);
        assertEquals(url, "https://test.backlog.jp/wiki/TEST_PROJECT/ABC+wiki");

        wiki = new DummyWiki() {
            @Override
            public String getName() {
                return "テストwiki&&//''";
            }
        };
        url = client.getWikiUrl(project, wiki);
        assertEquals(url, "https://test.backlog.jp/wiki/TEST_PROJECT/%E3%83%86%E3%82%B9%E3%83%88wiki%26%26%2F%2F%27%27");

    }

    private class DummyProject implements Project {
        @Override
        public long getId() {
            return 0;
        }

        @Override
        public String getIdAsString() {
            return null;
        }

        @Override
        public String getProjectKey() {
            return null;
        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public boolean isChartEnabled() {
            return false;
        }

        @Override
        public boolean isSubtaskingEnabled() {
            return false;
        }

        @Override
        public TextFormattingRule getTextFormattingRule() {
            return null;
        }

        @Override
        public boolean isArchived() {
            return false;
        }

        @Override
        public long getDisplayOrder() {
            return 0;
        }
    }

    private class DummyWiki implements Wiki {
        @Override
        public long getId() {
            return 0;
        }

        @Override
        public String getIdAsString() {
            return null;
        }

        @Override
        public long getProjectId() {
            return 0;
        }

        @Override
        public String getProjectIdAsString() {
            return null;
        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public String getContent() {
            return null;
        }

        @Override
        public List<WikiTag> getTags() {
            return null;
        }

        @Override
        public List<Attachment> getAttachments() {
            return null;
        }

        @Override
        public List<SharedFile> getSharedFiles() {
            return null;
        }

        @Override
        public List<Star> getStars() {
            return null;
        }

        @Override
        public User getCreatedUser() {
            return null;
        }

        @Override
        public Date getCreated() {
            return null;
        }

        @Override
        public User getUpdatedUser() {
            return null;
        }

        @Override
        public Date getUpdated() {
            return null;
        }

        private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        protected Date parseDate(String dataStr) {
            try {
                return format.parse(dataStr);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

}
