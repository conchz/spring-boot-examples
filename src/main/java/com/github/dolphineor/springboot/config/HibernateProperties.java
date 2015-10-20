package com.github.dolphineor.springboot.config;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

/**
 * Created on 2015-10-18.
 *
 * @author dolphineor
 */
@Component
@ConfigurationProperties(prefix = "hibernate", locations = "classpath:hibernate.properties")
public class HibernateProperties {
    private String dialect;

    private int max_fetch_depth;

    private boolean show_sql;

    private Hikari hikari;

    private Archive archive;

    private Cache cache;

    private Hbm2ddl hbm2ddl;


    public String getDialect() {
        return dialect;
    }

    public void setDialect(String dialect) {
        this.dialect = dialect;
    }

    public int getMax_fetch_depth() {
        return max_fetch_depth;
    }

    public void setMax_fetch_depth(int max_fetch_depth) {
        this.max_fetch_depth = max_fetch_depth;
    }

    public boolean isShow_sql() {
        return show_sql;
    }

    public void setShow_sql(boolean show_sql) {
        this.show_sql = show_sql;
    }

    public Hikari getHikari() {
        return hikari;
    }

    public void setHikari(Hikari hikari) {
        this.hikari = hikari;
    }

    public Archive getArchive() {
        return archive;
    }

    public void setArchive(Archive archive) {
        this.archive = archive;
    }

    public Cache getCache() {
        return cache;
    }

    public void setCache(Cache cache) {
        this.cache = cache;
    }

    public Hbm2ddl getHbm2ddl() {
        return hbm2ddl;
    }

    public void setHbm2ddl(Hbm2ddl hbm2ddl) {
        this.hbm2ddl = hbm2ddl;
    }

    protected static class Hikari {
        private int minimumIdle;

        private int maximumPoolSize;

        private int connectionTimeout;

        private int idleTimeout;

        private String connectionTestQuery;

        private String dataSourceClassName;

        @NotNull
        private DataSource dataSource;


        public int getMinimumIdle() {
            return minimumIdle;
        }

        public void setMinimumIdle(int minimumIdle) {
            this.minimumIdle = minimumIdle;
        }

        public int getMaximumPoolSize() {
            return maximumPoolSize;
        }

        public void setMaximumPoolSize(int maximumPoolSize) {
            this.maximumPoolSize = maximumPoolSize;
        }

        public int getConnectionTimeout() {
            return connectionTimeout;
        }

        public void setConnectionTimeout(int connectionTimeout) {
            this.connectionTimeout = connectionTimeout;
        }

        public int getIdleTimeout() {
            return idleTimeout;
        }

        public void setIdleTimeout(int idleTimeout) {
            this.idleTimeout = idleTimeout;
        }

        public String getConnectionTestQuery() {
            return connectionTestQuery;
        }

        public void setConnectionTestQuery(String connectionTestQuery) {
            this.connectionTestQuery = connectionTestQuery;
        }

        public String getDataSourceClassName() {
            return dataSourceClassName;
        }

        public void setDataSourceClassName(String dataSourceClassName) {
            this.dataSourceClassName = dataSourceClassName;
        }

        public DataSource getDataSource() {
            return dataSource;
        }

        public void setDataSource(DataSource dataSource) {
            this.dataSource = dataSource;
        }

        protected static class DataSource {
            @NotEmpty
            private String url;

            @NotEmpty
            private String user;

            @NotEmpty
            private String password;

            private boolean cachePrepStmts = true;

            private int prepStmtCacheSize = 300;

            private int prepStmtCacheSqlLimit = 2048;


            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getUser() {
                return user;
            }

            public void setUser(String user) {
                this.user = user;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public boolean isCachePrepStmts() {
                return cachePrepStmts;
            }

            public void setCachePrepStmts(boolean cachePrepStmts) {
                this.cachePrepStmts = cachePrepStmts;
            }

            public int getPrepStmtCacheSize() {
                return prepStmtCacheSize;
            }

            public void setPrepStmtCacheSize(int prepStmtCacheSize) {
                this.prepStmtCacheSize = prepStmtCacheSize;
            }

            public int getPrepStmtCacheSqlLimit() {
                return prepStmtCacheSqlLimit;
            }

            public void setPrepStmtCacheSqlLimit(int prepStmtCacheSqlLimit) {
                this.prepStmtCacheSqlLimit = prepStmtCacheSqlLimit;
            }
        }
    }

    protected static class Archive {
        private String autodetection;


        public String getAutodetection() {
            return autodetection;
        }

        public void setAutodetection(String autodetection) {
            this.autodetection = autodetection;
        }
    }

    protected static class Cache {
        private boolean use_second_level_cache;

        private boolean use_query_cache;

        private Region region;


        public boolean isUse_second_level_cache() {
            return use_second_level_cache;
        }

        public void setUse_second_level_cache(boolean use_second_level_cache) {
            this.use_second_level_cache = use_second_level_cache;
        }

        public boolean isUse_query_cache() {
            return use_query_cache;
        }

        public void setUse_query_cache(boolean use_query_cache) {
            this.use_query_cache = use_query_cache;
        }

        public Region getRegion() {
            return region;
        }

        public void setRegion(Region region) {
            this.region = region;
        }


        protected static class Region {
            private String factory_class;


            public String getFactory_class() {
                return factory_class;
            }

            public void setFactory_class(String factory_class) {
                this.factory_class = factory_class;
            }
        }
    }

    protected static class Hbm2ddl {
        private String auto;


        public String getAuto() {
            return auto;
        }

        public void setAuto(String auto) {
            this.auto = auto;
        }
    }
}
