package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the {@code libs} extension.
 */
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final ComLibraryAccessors laccForComLibraryAccessors = new ComLibraryAccessors(owner);
    private final JakartaLibraryAccessors laccForJakartaLibraryAccessors = new JakartaLibraryAccessors(owner);
    private final OrgLibraryAccessors laccForOrgLibraryAccessors = new OrgLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

    /**
     * Group of libraries at <b>com</b>
     */
    public ComLibraryAccessors getCom() {
        return laccForComLibraryAccessors;
    }

    /**
     * Group of libraries at <b>jakarta</b>
     */
    public JakartaLibraryAccessors getJakarta() {
        return laccForJakartaLibraryAccessors;
    }

    /**
     * Group of libraries at <b>org</b>
     */
    public OrgLibraryAccessors getOrg() {
        return laccForOrgLibraryAccessors;
    }

    /**
     * Group of versions at <b>versions</b>
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Group of bundles at <b>bundles</b>
     */
    public BundleAccessors getBundles() {
        return baccForBundleAccessors;
    }

    /**
     * Group of plugins at <b>plugins</b>
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    public static class ComLibraryAccessors extends SubDependencyFactory {
        private final ComMysqlLibraryAccessors laccForComMysqlLibraryAccessors = new ComMysqlLibraryAccessors(owner);

        public ComLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.mysql</b>
         */
        public ComMysqlLibraryAccessors getMysql() {
            return laccForComMysqlLibraryAccessors;
        }

    }

    public static class ComMysqlLibraryAccessors extends SubDependencyFactory {
        private final ComMysqlMysqlLibraryAccessors laccForComMysqlMysqlLibraryAccessors = new ComMysqlMysqlLibraryAccessors(owner);

        public ComMysqlLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.mysql.mysql</b>
         */
        public ComMysqlMysqlLibraryAccessors getMysql() {
            return laccForComMysqlMysqlLibraryAccessors;
        }

    }

    public static class ComMysqlMysqlLibraryAccessors extends SubDependencyFactory {
        private final ComMysqlMysqlConnectorLibraryAccessors laccForComMysqlMysqlConnectorLibraryAccessors = new ComMysqlMysqlConnectorLibraryAccessors(owner);

        public ComMysqlMysqlLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.mysql.mysql.connector</b>
         */
        public ComMysqlMysqlConnectorLibraryAccessors getConnector() {
            return laccForComMysqlMysqlConnectorLibraryAccessors;
        }

    }

    public static class ComMysqlMysqlConnectorLibraryAccessors extends SubDependencyFactory {

        public ComMysqlMysqlConnectorLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>j</b> with <b>com.mysql:mysql-connector-j</b> coordinates and
         * with version reference <b>com.mysql.mysql.connector.j</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJ() {
            return create("com.mysql.mysql.connector.j");
        }

    }

    public static class JakartaLibraryAccessors extends SubDependencyFactory {
        private final JakartaServletLibraryAccessors laccForJakartaServletLibraryAccessors = new JakartaServletLibraryAccessors(owner);

        public JakartaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>jakarta.servlet</b>
         */
        public JakartaServletLibraryAccessors getServlet() {
            return laccForJakartaServletLibraryAccessors;
        }

    }

    public static class JakartaServletLibraryAccessors extends SubDependencyFactory {
        private final JakartaServletJakartaLibraryAccessors laccForJakartaServletJakartaLibraryAccessors = new JakartaServletJakartaLibraryAccessors(owner);

        public JakartaServletLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>jakarta.servlet.jakarta</b>
         */
        public JakartaServletJakartaLibraryAccessors getJakarta() {
            return laccForJakartaServletJakartaLibraryAccessors;
        }

    }

    public static class JakartaServletJakartaLibraryAccessors extends SubDependencyFactory {
        private final JakartaServletJakartaServletLibraryAccessors laccForJakartaServletJakartaServletLibraryAccessors = new JakartaServletJakartaServletLibraryAccessors(owner);

        public JakartaServletJakartaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>jakarta.servlet.jakarta.servlet</b>
         */
        public JakartaServletJakartaServletLibraryAccessors getServlet() {
            return laccForJakartaServletJakartaServletLibraryAccessors;
        }

    }

    public static class JakartaServletJakartaServletLibraryAccessors extends SubDependencyFactory {

        public JakartaServletJakartaServletLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>api</b> with <b>jakarta.servlet:jakarta.servlet-api</b> coordinates and
         * with version reference <b>jakarta.servlet.jakarta.servlet.api</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getApi() {
            return create("jakarta.servlet.jakarta.servlet.api");
        }

    }

    public static class OrgLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheLibraryAccessors laccForOrgApacheLibraryAccessors = new OrgApacheLibraryAccessors(owner);
        private final OrgGlassfishLibraryAccessors laccForOrgGlassfishLibraryAccessors = new OrgGlassfishLibraryAccessors(owner);
        private final OrgMybatisLibraryAccessors laccForOrgMybatisLibraryAccessors = new OrgMybatisLibraryAccessors(owner);
        private final OrgSeleniumhqLibraryAccessors laccForOrgSeleniumhqLibraryAccessors = new OrgSeleniumhqLibraryAccessors(owner);
        private final OrgSpringframeworkLibraryAccessors laccForOrgSpringframeworkLibraryAccessors = new OrgSpringframeworkLibraryAccessors(owner);

        public OrgLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.apache</b>
         */
        public OrgApacheLibraryAccessors getApache() {
            return laccForOrgApacheLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.glassfish</b>
         */
        public OrgGlassfishLibraryAccessors getGlassfish() {
            return laccForOrgGlassfishLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.mybatis</b>
         */
        public OrgMybatisLibraryAccessors getMybatis() {
            return laccForOrgMybatisLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.seleniumhq</b>
         */
        public OrgSeleniumhqLibraryAccessors getSeleniumhq() {
            return laccForOrgSeleniumhqLibraryAccessors;
        }

        /**
         * Group of libraries at <b>org.springframework</b>
         */
        public OrgSpringframeworkLibraryAccessors getSpringframework() {
            return laccForOrgSpringframeworkLibraryAccessors;
        }

    }

    public static class OrgApacheLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheTomcatLibraryAccessors laccForOrgApacheTomcatLibraryAccessors = new OrgApacheTomcatLibraryAccessors(owner);

        public OrgApacheLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.apache.tomcat</b>
         */
        public OrgApacheTomcatLibraryAccessors getTomcat() {
            return laccForOrgApacheTomcatLibraryAccessors;
        }

    }

    public static class OrgApacheTomcatLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheTomcatEmbedLibraryAccessors laccForOrgApacheTomcatEmbedLibraryAccessors = new OrgApacheTomcatEmbedLibraryAccessors(owner);

        public OrgApacheTomcatLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.apache.tomcat.embed</b>
         */
        public OrgApacheTomcatEmbedLibraryAccessors getEmbed() {
            return laccForOrgApacheTomcatEmbedLibraryAccessors;
        }

    }

    public static class OrgApacheTomcatEmbedLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheTomcatEmbedTomcatLibraryAccessors laccForOrgApacheTomcatEmbedTomcatLibraryAccessors = new OrgApacheTomcatEmbedTomcatLibraryAccessors(owner);

        public OrgApacheTomcatEmbedLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.apache.tomcat.embed.tomcat</b>
         */
        public OrgApacheTomcatEmbedTomcatLibraryAccessors getTomcat() {
            return laccForOrgApacheTomcatEmbedTomcatLibraryAccessors;
        }

    }

    public static class OrgApacheTomcatEmbedTomcatLibraryAccessors extends SubDependencyFactory {
        private final OrgApacheTomcatEmbedTomcatEmbedLibraryAccessors laccForOrgApacheTomcatEmbedTomcatEmbedLibraryAccessors = new OrgApacheTomcatEmbedTomcatEmbedLibraryAccessors(owner);

        public OrgApacheTomcatEmbedTomcatLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.apache.tomcat.embed.tomcat.embed</b>
         */
        public OrgApacheTomcatEmbedTomcatEmbedLibraryAccessors getEmbed() {
            return laccForOrgApacheTomcatEmbedTomcatEmbedLibraryAccessors;
        }

    }

    public static class OrgApacheTomcatEmbedTomcatEmbedLibraryAccessors extends SubDependencyFactory {

        public OrgApacheTomcatEmbedTomcatEmbedLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>jasper</b> with <b>org.apache.tomcat.embed:tomcat-embed-jasper</b> coordinates and
         * with version reference <b>org.apache.tomcat.embed.tomcat.embed.jasper</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJasper() {
            return create("org.apache.tomcat.embed.tomcat.embed.jasper");
        }

    }

    public static class OrgGlassfishLibraryAccessors extends SubDependencyFactory {
        private final OrgGlassfishWebLibraryAccessors laccForOrgGlassfishWebLibraryAccessors = new OrgGlassfishWebLibraryAccessors(owner);

        public OrgGlassfishLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.glassfish.web</b>
         */
        public OrgGlassfishWebLibraryAccessors getWeb() {
            return laccForOrgGlassfishWebLibraryAccessors;
        }

    }

    public static class OrgGlassfishWebLibraryAccessors extends SubDependencyFactory {
        private final OrgGlassfishWebJakartaLibraryAccessors laccForOrgGlassfishWebJakartaLibraryAccessors = new OrgGlassfishWebJakartaLibraryAccessors(owner);

        public OrgGlassfishWebLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.glassfish.web.jakarta</b>
         */
        public OrgGlassfishWebJakartaLibraryAccessors getJakarta() {
            return laccForOrgGlassfishWebJakartaLibraryAccessors;
        }

    }

    public static class OrgGlassfishWebJakartaLibraryAccessors extends SubDependencyFactory {
        private final OrgGlassfishWebJakartaServletLibraryAccessors laccForOrgGlassfishWebJakartaServletLibraryAccessors = new OrgGlassfishWebJakartaServletLibraryAccessors(owner);

        public OrgGlassfishWebJakartaLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.glassfish.web.jakarta.servlet</b>
         */
        public OrgGlassfishWebJakartaServletLibraryAccessors getServlet() {
            return laccForOrgGlassfishWebJakartaServletLibraryAccessors;
        }

    }

    public static class OrgGlassfishWebJakartaServletLibraryAccessors extends SubDependencyFactory {
        private final OrgGlassfishWebJakartaServletJspLibraryAccessors laccForOrgGlassfishWebJakartaServletJspLibraryAccessors = new OrgGlassfishWebJakartaServletJspLibraryAccessors(owner);

        public OrgGlassfishWebJakartaServletLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.glassfish.web.jakarta.servlet.jsp</b>
         */
        public OrgGlassfishWebJakartaServletJspLibraryAccessors getJsp() {
            return laccForOrgGlassfishWebJakartaServletJspLibraryAccessors;
        }

    }

    public static class OrgGlassfishWebJakartaServletJspLibraryAccessors extends SubDependencyFactory {

        public OrgGlassfishWebJakartaServletJspLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>jstl</b> with <b>org.glassfish.web:jakarta.servlet.jsp.jstl</b> coordinates and
         * with version reference <b>org.glassfish.web.jakarta.servlet.jsp.jstl</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJstl() {
            return create("org.glassfish.web.jakarta.servlet.jsp.jstl");
        }

    }

    public static class OrgMybatisLibraryAccessors extends SubDependencyFactory {
        private final OrgMybatisSpringLibraryAccessors laccForOrgMybatisSpringLibraryAccessors = new OrgMybatisSpringLibraryAccessors(owner);

        public OrgMybatisLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.mybatis.spring</b>
         */
        public OrgMybatisSpringLibraryAccessors getSpring() {
            return laccForOrgMybatisSpringLibraryAccessors;
        }

    }

    public static class OrgMybatisSpringLibraryAccessors extends SubDependencyFactory {
        private final OrgMybatisSpringBootLibraryAccessors laccForOrgMybatisSpringBootLibraryAccessors = new OrgMybatisSpringBootLibraryAccessors(owner);

        public OrgMybatisSpringLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.mybatis.spring.boot</b>
         */
        public OrgMybatisSpringBootLibraryAccessors getBoot() {
            return laccForOrgMybatisSpringBootLibraryAccessors;
        }

    }

    public static class OrgMybatisSpringBootLibraryAccessors extends SubDependencyFactory {
        private final OrgMybatisSpringBootMybatisLibraryAccessors laccForOrgMybatisSpringBootMybatisLibraryAccessors = new OrgMybatisSpringBootMybatisLibraryAccessors(owner);

        public OrgMybatisSpringBootLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.mybatis.spring.boot.mybatis</b>
         */
        public OrgMybatisSpringBootMybatisLibraryAccessors getMybatis() {
            return laccForOrgMybatisSpringBootMybatisLibraryAccessors;
        }

    }

    public static class OrgMybatisSpringBootMybatisLibraryAccessors extends SubDependencyFactory {
        private final OrgMybatisSpringBootMybatisSpringLibraryAccessors laccForOrgMybatisSpringBootMybatisSpringLibraryAccessors = new OrgMybatisSpringBootMybatisSpringLibraryAccessors(owner);

        public OrgMybatisSpringBootMybatisLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.mybatis.spring.boot.mybatis.spring</b>
         */
        public OrgMybatisSpringBootMybatisSpringLibraryAccessors getSpring() {
            return laccForOrgMybatisSpringBootMybatisSpringLibraryAccessors;
        }

    }

    public static class OrgMybatisSpringBootMybatisSpringLibraryAccessors extends SubDependencyFactory {
        private final OrgMybatisSpringBootMybatisSpringBootLibraryAccessors laccForOrgMybatisSpringBootMybatisSpringBootLibraryAccessors = new OrgMybatisSpringBootMybatisSpringBootLibraryAccessors(owner);

        public OrgMybatisSpringBootMybatisSpringLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.mybatis.spring.boot.mybatis.spring.boot</b>
         */
        public OrgMybatisSpringBootMybatisSpringBootLibraryAccessors getBoot() {
            return laccForOrgMybatisSpringBootMybatisSpringBootLibraryAccessors;
        }

    }

    public static class OrgMybatisSpringBootMybatisSpringBootLibraryAccessors extends SubDependencyFactory {
        private final OrgMybatisSpringBootMybatisSpringBootStarterLibraryAccessors laccForOrgMybatisSpringBootMybatisSpringBootStarterLibraryAccessors = new OrgMybatisSpringBootMybatisSpringBootStarterLibraryAccessors(owner);

        public OrgMybatisSpringBootMybatisSpringBootLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.mybatis.spring.boot.mybatis.spring.boot.starter</b>
         */
        public OrgMybatisSpringBootMybatisSpringBootStarterLibraryAccessors getStarter() {
            return laccForOrgMybatisSpringBootMybatisSpringBootStarterLibraryAccessors;
        }

    }

    public static class OrgMybatisSpringBootMybatisSpringBootStarterLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public OrgMybatisSpringBootMybatisSpringBootStarterLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>starter</b> with <b>org.mybatis.spring.boot:mybatis-spring-boot-starter</b> coordinates and
         * with version reference <b>org.mybatis.spring.boot.mybatis.spring.boot.starter</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("org.mybatis.spring.boot.mybatis.spring.boot.starter");
        }

        /**
         * Dependency provider for <b>test</b> with <b>org.mybatis.spring.boot:mybatis-spring-boot-starter-test</b> coordinates and
         * with version reference <b>org.mybatis.spring.boot.mybatis.spring.boot.starter.test</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getTest() {
            return create("org.mybatis.spring.boot.mybatis.spring.boot.starter.test");
        }

    }

    public static class OrgSeleniumhqLibraryAccessors extends SubDependencyFactory {
        private final OrgSeleniumhqSeleniumLibraryAccessors laccForOrgSeleniumhqSeleniumLibraryAccessors = new OrgSeleniumhqSeleniumLibraryAccessors(owner);

        public OrgSeleniumhqLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.seleniumhq.selenium</b>
         */
        public OrgSeleniumhqSeleniumLibraryAccessors getSelenium() {
            return laccForOrgSeleniumhqSeleniumLibraryAccessors;
        }

    }

    public static class OrgSeleniumhqSeleniumLibraryAccessors extends SubDependencyFactory {
        private final OrgSeleniumhqSeleniumSeleniumLibraryAccessors laccForOrgSeleniumhqSeleniumSeleniumLibraryAccessors = new OrgSeleniumhqSeleniumSeleniumLibraryAccessors(owner);

        public OrgSeleniumhqSeleniumLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.seleniumhq.selenium.selenium</b>
         */
        public OrgSeleniumhqSeleniumSeleniumLibraryAccessors getSelenium() {
            return laccForOrgSeleniumhqSeleniumSeleniumLibraryAccessors;
        }

    }

    public static class OrgSeleniumhqSeleniumSeleniumLibraryAccessors extends SubDependencyFactory {

        public OrgSeleniumhqSeleniumSeleniumLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>java</b> with <b>org.seleniumhq.selenium:selenium-java</b> coordinates and
         * with version reference <b>org.seleniumhq.selenium.selenium.java</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJava() {
            return create("org.seleniumhq.selenium.selenium.java");
        }

    }

    public static class OrgSpringframeworkLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootLibraryAccessors laccForOrgSpringframeworkBootLibraryAccessors = new OrgSpringframeworkBootLibraryAccessors(owner);

        public OrgSpringframeworkLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.springframework.boot</b>
         */
        public OrgSpringframeworkBootLibraryAccessors getBoot() {
            return laccForOrgSpringframeworkBootLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBootLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootSpringLibraryAccessors laccForOrgSpringframeworkBootSpringLibraryAccessors = new OrgSpringframeworkBootSpringLibraryAccessors(owner);

        public OrgSpringframeworkBootLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.springframework.boot.spring</b>
         */
        public OrgSpringframeworkBootSpringLibraryAccessors getSpring() {
            return laccForOrgSpringframeworkBootSpringLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootSpringBootLibraryAccessors laccForOrgSpringframeworkBootSpringBootLibraryAccessors = new OrgSpringframeworkBootSpringBootLibraryAccessors(owner);

        public OrgSpringframeworkBootSpringLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>org.springframework.boot.spring.boot</b>
         */
        public OrgSpringframeworkBootSpringBootLibraryAccessors getBoot() {
            return laccForOrgSpringframeworkBootSpringBootLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootSpringBootStarterLibraryAccessors laccForOrgSpringframeworkBootSpringBootStarterLibraryAccessors = new OrgSpringframeworkBootSpringBootStarterLibraryAccessors(owner);

        public OrgSpringframeworkBootSpringBootLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>devtools</b> with <b>org.springframework.boot:spring-boot-devtools</b> coordinates and
         * with version reference <b>org.springframework.boot.spring.boot.devtools</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getDevtools() {
            return create("org.springframework.boot.spring.boot.devtools");
        }

        /**
         * Group of libraries at <b>org.springframework.boot.spring.boot.starter</b>
         */
        public OrgSpringframeworkBootSpringBootStarterLibraryAccessors getStarter() {
            return laccForOrgSpringframeworkBootSpringBootStarterLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootStarterLibraryAccessors extends SubDependencyFactory {
        private final OrgSpringframeworkBootSpringBootStarterDataLibraryAccessors laccForOrgSpringframeworkBootSpringBootStarterDataLibraryAccessors = new OrgSpringframeworkBootSpringBootStarterDataLibraryAccessors(owner);

        public OrgSpringframeworkBootSpringBootStarterLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>test</b> with <b>org.springframework.boot:spring-boot-starter-test</b> coordinates and
         * with version reference <b>org.springframework.boot.spring.boot.starter.test</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getTest() {
            return create("org.springframework.boot.spring.boot.starter.test");
        }

        /**
         * Dependency provider for <b>tomcat</b> with <b>org.springframework.boot:spring-boot-starter-tomcat</b> coordinates and
         * with version reference <b>org.springframework.boot.spring.boot.starter.tomcat</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getTomcat() {
            return create("org.springframework.boot.spring.boot.starter.tomcat");
        }

        /**
         * Dependency provider for <b>web</b> with <b>org.springframework.boot:spring-boot-starter-web</b> coordinates and
         * with version reference <b>org.springframework.boot.spring.boot.starter.web</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getWeb() {
            return create("org.springframework.boot.spring.boot.starter.web");
        }

        /**
         * Dependency provider for <b>websocket</b> with <b>org.springframework.boot:spring-boot-starter-websocket</b> coordinates and
         * with version reference <b>org.springframework.boot.spring.boot.starter.websocket</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getWebsocket() {
            return create("org.springframework.boot.spring.boot.starter.websocket");
        }

        /**
         * Group of libraries at <b>org.springframework.boot.spring.boot.starter.data</b>
         */
        public OrgSpringframeworkBootSpringBootStarterDataLibraryAccessors getData() {
            return laccForOrgSpringframeworkBootSpringBootStarterDataLibraryAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootStarterDataLibraryAccessors extends SubDependencyFactory {

        public OrgSpringframeworkBootSpringBootStarterDataLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>jdbc</b> with <b>org.springframework.boot:spring-boot-starter-data-jdbc</b> coordinates and
         * with version reference <b>org.springframework.boot.spring.boot.starter.data.jdbc</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJdbc() {
            return create("org.springframework.boot.spring.boot.starter.data.jdbc");
        }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final ComVersionAccessors vaccForComVersionAccessors = new ComVersionAccessors(providers, config);
        private final JakartaVersionAccessors vaccForJakartaVersionAccessors = new JakartaVersionAccessors(providers, config);
        private final OrgVersionAccessors vaccForOrgVersionAccessors = new OrgVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com</b>
         */
        public ComVersionAccessors getCom() {
            return vaccForComVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.jakarta</b>
         */
        public JakartaVersionAccessors getJakarta() {
            return vaccForJakartaVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org</b>
         */
        public OrgVersionAccessors getOrg() {
            return vaccForOrgVersionAccessors;
        }

    }

    public static class ComVersionAccessors extends VersionFactory  {

        private final ComMysqlVersionAccessors vaccForComMysqlVersionAccessors = new ComMysqlVersionAccessors(providers, config);
        public ComVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.mysql</b>
         */
        public ComMysqlVersionAccessors getMysql() {
            return vaccForComMysqlVersionAccessors;
        }

    }

    public static class ComMysqlVersionAccessors extends VersionFactory  {

        private final ComMysqlMysqlVersionAccessors vaccForComMysqlMysqlVersionAccessors = new ComMysqlMysqlVersionAccessors(providers, config);
        public ComMysqlVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.mysql.mysql</b>
         */
        public ComMysqlMysqlVersionAccessors getMysql() {
            return vaccForComMysqlMysqlVersionAccessors;
        }

    }

    public static class ComMysqlMysqlVersionAccessors extends VersionFactory  {

        private final ComMysqlMysqlConnectorVersionAccessors vaccForComMysqlMysqlConnectorVersionAccessors = new ComMysqlMysqlConnectorVersionAccessors(providers, config);
        public ComMysqlMysqlVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.mysql.mysql.connector</b>
         */
        public ComMysqlMysqlConnectorVersionAccessors getConnector() {
            return vaccForComMysqlMysqlConnectorVersionAccessors;
        }

    }

    public static class ComMysqlMysqlConnectorVersionAccessors extends VersionFactory  {

        public ComMysqlMysqlConnectorVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>com.mysql.mysql.connector.j</b> with value <b>8.3.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJ() { return getVersion("com.mysql.mysql.connector.j"); }

    }

    public static class JakartaVersionAccessors extends VersionFactory  {

        private final JakartaServletVersionAccessors vaccForJakartaServletVersionAccessors = new JakartaServletVersionAccessors(providers, config);
        public JakartaVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.jakarta.servlet</b>
         */
        public JakartaServletVersionAccessors getServlet() {
            return vaccForJakartaServletVersionAccessors;
        }

    }

    public static class JakartaServletVersionAccessors extends VersionFactory  {

        private final JakartaServletJakartaVersionAccessors vaccForJakartaServletJakartaVersionAccessors = new JakartaServletJakartaVersionAccessors(providers, config);
        public JakartaServletVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.jakarta.servlet.jakarta</b>
         */
        public JakartaServletJakartaVersionAccessors getJakarta() {
            return vaccForJakartaServletJakartaVersionAccessors;
        }

    }

    public static class JakartaServletJakartaVersionAccessors extends VersionFactory  {

        private final JakartaServletJakartaServletVersionAccessors vaccForJakartaServletJakartaServletVersionAccessors = new JakartaServletJakartaServletVersionAccessors(providers, config);
        public JakartaServletJakartaVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.jakarta.servlet.jakarta.servlet</b>
         */
        public JakartaServletJakartaServletVersionAccessors getServlet() {
            return vaccForJakartaServletJakartaServletVersionAccessors;
        }

    }

    public static class JakartaServletJakartaServletVersionAccessors extends VersionFactory  {

        public JakartaServletJakartaServletVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>jakarta.servlet.jakarta.servlet.api</b> with value <b>6.0.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getApi() { return getVersion("jakarta.servlet.jakarta.servlet.api"); }

    }

    public static class OrgVersionAccessors extends VersionFactory  {

        private final OrgApacheVersionAccessors vaccForOrgApacheVersionAccessors = new OrgApacheVersionAccessors(providers, config);
        private final OrgGlassfishVersionAccessors vaccForOrgGlassfishVersionAccessors = new OrgGlassfishVersionAccessors(providers, config);
        private final OrgMybatisVersionAccessors vaccForOrgMybatisVersionAccessors = new OrgMybatisVersionAccessors(providers, config);
        private final OrgSeleniumhqVersionAccessors vaccForOrgSeleniumhqVersionAccessors = new OrgSeleniumhqVersionAccessors(providers, config);
        private final OrgSpringframeworkVersionAccessors vaccForOrgSpringframeworkVersionAccessors = new OrgSpringframeworkVersionAccessors(providers, config);
        public OrgVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.apache</b>
         */
        public OrgApacheVersionAccessors getApache() {
            return vaccForOrgApacheVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.glassfish</b>
         */
        public OrgGlassfishVersionAccessors getGlassfish() {
            return vaccForOrgGlassfishVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.mybatis</b>
         */
        public OrgMybatisVersionAccessors getMybatis() {
            return vaccForOrgMybatisVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.seleniumhq</b>
         */
        public OrgSeleniumhqVersionAccessors getSeleniumhq() {
            return vaccForOrgSeleniumhqVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.org.springframework</b>
         */
        public OrgSpringframeworkVersionAccessors getSpringframework() {
            return vaccForOrgSpringframeworkVersionAccessors;
        }

    }

    public static class OrgApacheVersionAccessors extends VersionFactory  {

        private final OrgApacheTomcatVersionAccessors vaccForOrgApacheTomcatVersionAccessors = new OrgApacheTomcatVersionAccessors(providers, config);
        public OrgApacheVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.apache.tomcat</b>
         */
        public OrgApacheTomcatVersionAccessors getTomcat() {
            return vaccForOrgApacheTomcatVersionAccessors;
        }

    }

    public static class OrgApacheTomcatVersionAccessors extends VersionFactory  {

        private final OrgApacheTomcatEmbedVersionAccessors vaccForOrgApacheTomcatEmbedVersionAccessors = new OrgApacheTomcatEmbedVersionAccessors(providers, config);
        public OrgApacheTomcatVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.apache.tomcat.embed</b>
         */
        public OrgApacheTomcatEmbedVersionAccessors getEmbed() {
            return vaccForOrgApacheTomcatEmbedVersionAccessors;
        }

    }

    public static class OrgApacheTomcatEmbedVersionAccessors extends VersionFactory  {

        private final OrgApacheTomcatEmbedTomcatVersionAccessors vaccForOrgApacheTomcatEmbedTomcatVersionAccessors = new OrgApacheTomcatEmbedTomcatVersionAccessors(providers, config);
        public OrgApacheTomcatEmbedVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.apache.tomcat.embed.tomcat</b>
         */
        public OrgApacheTomcatEmbedTomcatVersionAccessors getTomcat() {
            return vaccForOrgApacheTomcatEmbedTomcatVersionAccessors;
        }

    }

    public static class OrgApacheTomcatEmbedTomcatVersionAccessors extends VersionFactory  {

        private final OrgApacheTomcatEmbedTomcatEmbedVersionAccessors vaccForOrgApacheTomcatEmbedTomcatEmbedVersionAccessors = new OrgApacheTomcatEmbedTomcatEmbedVersionAccessors(providers, config);
        public OrgApacheTomcatEmbedTomcatVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.apache.tomcat.embed.tomcat.embed</b>
         */
        public OrgApacheTomcatEmbedTomcatEmbedVersionAccessors getEmbed() {
            return vaccForOrgApacheTomcatEmbedTomcatEmbedVersionAccessors;
        }

    }

    public static class OrgApacheTomcatEmbedTomcatEmbedVersionAccessors extends VersionFactory  {

        public OrgApacheTomcatEmbedTomcatEmbedVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.apache.tomcat.embed.tomcat.embed.jasper</b> with value <b>10.1.20</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJasper() { return getVersion("org.apache.tomcat.embed.tomcat.embed.jasper"); }

    }

    public static class OrgGlassfishVersionAccessors extends VersionFactory  {

        private final OrgGlassfishWebVersionAccessors vaccForOrgGlassfishWebVersionAccessors = new OrgGlassfishWebVersionAccessors(providers, config);
        public OrgGlassfishVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.glassfish.web</b>
         */
        public OrgGlassfishWebVersionAccessors getWeb() {
            return vaccForOrgGlassfishWebVersionAccessors;
        }

    }

    public static class OrgGlassfishWebVersionAccessors extends VersionFactory  {

        private final OrgGlassfishWebJakartaVersionAccessors vaccForOrgGlassfishWebJakartaVersionAccessors = new OrgGlassfishWebJakartaVersionAccessors(providers, config);
        public OrgGlassfishWebVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.glassfish.web.jakarta</b>
         */
        public OrgGlassfishWebJakartaVersionAccessors getJakarta() {
            return vaccForOrgGlassfishWebJakartaVersionAccessors;
        }

    }

    public static class OrgGlassfishWebJakartaVersionAccessors extends VersionFactory  {

        private final OrgGlassfishWebJakartaServletVersionAccessors vaccForOrgGlassfishWebJakartaServletVersionAccessors = new OrgGlassfishWebJakartaServletVersionAccessors(providers, config);
        public OrgGlassfishWebJakartaVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.glassfish.web.jakarta.servlet</b>
         */
        public OrgGlassfishWebJakartaServletVersionAccessors getServlet() {
            return vaccForOrgGlassfishWebJakartaServletVersionAccessors;
        }

    }

    public static class OrgGlassfishWebJakartaServletVersionAccessors extends VersionFactory  {

        private final OrgGlassfishWebJakartaServletJspVersionAccessors vaccForOrgGlassfishWebJakartaServletJspVersionAccessors = new OrgGlassfishWebJakartaServletJspVersionAccessors(providers, config);
        public OrgGlassfishWebJakartaServletVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.glassfish.web.jakarta.servlet.jsp</b>
         */
        public OrgGlassfishWebJakartaServletJspVersionAccessors getJsp() {
            return vaccForOrgGlassfishWebJakartaServletJspVersionAccessors;
        }

    }

    public static class OrgGlassfishWebJakartaServletJspVersionAccessors extends VersionFactory  {

        public OrgGlassfishWebJakartaServletJspVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.glassfish.web.jakarta.servlet.jsp.jstl</b> with value <b>2.0.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJstl() { return getVersion("org.glassfish.web.jakarta.servlet.jsp.jstl"); }

    }

    public static class OrgMybatisVersionAccessors extends VersionFactory  {

        private final OrgMybatisSpringVersionAccessors vaccForOrgMybatisSpringVersionAccessors = new OrgMybatisSpringVersionAccessors(providers, config);
        public OrgMybatisVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.mybatis.spring</b>
         */
        public OrgMybatisSpringVersionAccessors getSpring() {
            return vaccForOrgMybatisSpringVersionAccessors;
        }

    }

    public static class OrgMybatisSpringVersionAccessors extends VersionFactory  {

        private final OrgMybatisSpringBootVersionAccessors vaccForOrgMybatisSpringBootVersionAccessors = new OrgMybatisSpringBootVersionAccessors(providers, config);
        public OrgMybatisSpringVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.mybatis.spring.boot</b>
         */
        public OrgMybatisSpringBootVersionAccessors getBoot() {
            return vaccForOrgMybatisSpringBootVersionAccessors;
        }

    }

    public static class OrgMybatisSpringBootVersionAccessors extends VersionFactory  {

        private final OrgMybatisSpringBootMybatisVersionAccessors vaccForOrgMybatisSpringBootMybatisVersionAccessors = new OrgMybatisSpringBootMybatisVersionAccessors(providers, config);
        public OrgMybatisSpringBootVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.mybatis.spring.boot.mybatis</b>
         */
        public OrgMybatisSpringBootMybatisVersionAccessors getMybatis() {
            return vaccForOrgMybatisSpringBootMybatisVersionAccessors;
        }

    }

    public static class OrgMybatisSpringBootMybatisVersionAccessors extends VersionFactory  {

        private final OrgMybatisSpringBootMybatisSpringVersionAccessors vaccForOrgMybatisSpringBootMybatisSpringVersionAccessors = new OrgMybatisSpringBootMybatisSpringVersionAccessors(providers, config);
        public OrgMybatisSpringBootMybatisVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.mybatis.spring.boot.mybatis.spring</b>
         */
        public OrgMybatisSpringBootMybatisSpringVersionAccessors getSpring() {
            return vaccForOrgMybatisSpringBootMybatisSpringVersionAccessors;
        }

    }

    public static class OrgMybatisSpringBootMybatisSpringVersionAccessors extends VersionFactory  {

        private final OrgMybatisSpringBootMybatisSpringBootVersionAccessors vaccForOrgMybatisSpringBootMybatisSpringBootVersionAccessors = new OrgMybatisSpringBootMybatisSpringBootVersionAccessors(providers, config);
        public OrgMybatisSpringBootMybatisSpringVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.mybatis.spring.boot.mybatis.spring.boot</b>
         */
        public OrgMybatisSpringBootMybatisSpringBootVersionAccessors getBoot() {
            return vaccForOrgMybatisSpringBootMybatisSpringBootVersionAccessors;
        }

    }

    public static class OrgMybatisSpringBootMybatisSpringBootVersionAccessors extends VersionFactory  {

        private final OrgMybatisSpringBootMybatisSpringBootStarterVersionAccessors vaccForOrgMybatisSpringBootMybatisSpringBootStarterVersionAccessors = new OrgMybatisSpringBootMybatisSpringBootStarterVersionAccessors(providers, config);
        public OrgMybatisSpringBootMybatisSpringBootVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.mybatis.spring.boot.mybatis.spring.boot.starter</b>
         */
        public OrgMybatisSpringBootMybatisSpringBootStarterVersionAccessors getStarter() {
            return vaccForOrgMybatisSpringBootMybatisSpringBootStarterVersionAccessors;
        }

    }

    public static class OrgMybatisSpringBootMybatisSpringBootStarterVersionAccessors extends VersionFactory  implements VersionNotationSupplier {

        public OrgMybatisSpringBootMybatisSpringBootStarterVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.mybatis.spring.boot.mybatis.spring.boot.starter</b> with value <b>3.0.3</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> asProvider() { return getVersion("org.mybatis.spring.boot.mybatis.spring.boot.starter"); }

        /**
         * Version alias <b>org.mybatis.spring.boot.mybatis.spring.boot.starter.test</b> with value <b>3.0.3</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getTest() { return getVersion("org.mybatis.spring.boot.mybatis.spring.boot.starter.test"); }

    }

    public static class OrgSeleniumhqVersionAccessors extends VersionFactory  {

        private final OrgSeleniumhqSeleniumVersionAccessors vaccForOrgSeleniumhqSeleniumVersionAccessors = new OrgSeleniumhqSeleniumVersionAccessors(providers, config);
        public OrgSeleniumhqVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.seleniumhq.selenium</b>
         */
        public OrgSeleniumhqSeleniumVersionAccessors getSelenium() {
            return vaccForOrgSeleniumhqSeleniumVersionAccessors;
        }

    }

    public static class OrgSeleniumhqSeleniumVersionAccessors extends VersionFactory  {

        private final OrgSeleniumhqSeleniumSeleniumVersionAccessors vaccForOrgSeleniumhqSeleniumSeleniumVersionAccessors = new OrgSeleniumhqSeleniumSeleniumVersionAccessors(providers, config);
        public OrgSeleniumhqSeleniumVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.seleniumhq.selenium.selenium</b>
         */
        public OrgSeleniumhqSeleniumSeleniumVersionAccessors getSelenium() {
            return vaccForOrgSeleniumhqSeleniumSeleniumVersionAccessors;
        }

    }

    public static class OrgSeleniumhqSeleniumSeleniumVersionAccessors extends VersionFactory  {

        public OrgSeleniumhqSeleniumSeleniumVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.seleniumhq.selenium.selenium.java</b> with value <b>4.6.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJava() { return getVersion("org.seleniumhq.selenium.selenium.java"); }

    }

    public static class OrgSpringframeworkVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkBootVersionAccessors vaccForOrgSpringframeworkBootVersionAccessors = new OrgSpringframeworkBootVersionAccessors(providers, config);
        public OrgSpringframeworkVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.springframework.boot</b>
         */
        public OrgSpringframeworkBootVersionAccessors getBoot() {
            return vaccForOrgSpringframeworkBootVersionAccessors;
        }

    }

    public static class OrgSpringframeworkBootVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkBootSpringVersionAccessors vaccForOrgSpringframeworkBootSpringVersionAccessors = new OrgSpringframeworkBootSpringVersionAccessors(providers, config);
        public OrgSpringframeworkBootVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.springframework.boot.spring</b>
         */
        public OrgSpringframeworkBootSpringVersionAccessors getSpring() {
            return vaccForOrgSpringframeworkBootSpringVersionAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkBootSpringBootVersionAccessors vaccForOrgSpringframeworkBootSpringBootVersionAccessors = new OrgSpringframeworkBootSpringBootVersionAccessors(providers, config);
        public OrgSpringframeworkBootSpringVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.org.springframework.boot.spring.boot</b>
         */
        public OrgSpringframeworkBootSpringBootVersionAccessors getBoot() {
            return vaccForOrgSpringframeworkBootSpringBootVersionAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkBootSpringBootStarterVersionAccessors vaccForOrgSpringframeworkBootSpringBootStarterVersionAccessors = new OrgSpringframeworkBootSpringBootStarterVersionAccessors(providers, config);
        public OrgSpringframeworkBootSpringBootVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.springframework.boot.spring.boot.devtools</b> with value <b>3.2.5</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getDevtools() { return getVersion("org.springframework.boot.spring.boot.devtools"); }

        /**
         * Group of versions at <b>versions.org.springframework.boot.spring.boot.starter</b>
         */
        public OrgSpringframeworkBootSpringBootStarterVersionAccessors getStarter() {
            return vaccForOrgSpringframeworkBootSpringBootStarterVersionAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootStarterVersionAccessors extends VersionFactory  {

        private final OrgSpringframeworkBootSpringBootStarterDataVersionAccessors vaccForOrgSpringframeworkBootSpringBootStarterDataVersionAccessors = new OrgSpringframeworkBootSpringBootStarterDataVersionAccessors(providers, config);
        public OrgSpringframeworkBootSpringBootStarterVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.springframework.boot.spring.boot.starter.test</b> with value <b>3.2.5</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getTest() { return getVersion("org.springframework.boot.spring.boot.starter.test"); }

        /**
         * Version alias <b>org.springframework.boot.spring.boot.starter.tomcat</b> with value <b>3.2.5</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getTomcat() { return getVersion("org.springframework.boot.spring.boot.starter.tomcat"); }

        /**
         * Version alias <b>org.springframework.boot.spring.boot.starter.web</b> with value <b>3.2.5</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getWeb() { return getVersion("org.springframework.boot.spring.boot.starter.web"); }

        /**
         * Version alias <b>org.springframework.boot.spring.boot.starter.websocket</b> with value <b>3.2.5</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getWebsocket() { return getVersion("org.springframework.boot.spring.boot.starter.websocket"); }

        /**
         * Group of versions at <b>versions.org.springframework.boot.spring.boot.starter.data</b>
         */
        public OrgSpringframeworkBootSpringBootStarterDataVersionAccessors getData() {
            return vaccForOrgSpringframeworkBootSpringBootStarterDataVersionAccessors;
        }

    }

    public static class OrgSpringframeworkBootSpringBootStarterDataVersionAccessors extends VersionFactory  {

        public OrgSpringframeworkBootSpringBootStarterDataVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>org.springframework.boot.spring.boot.starter.data.jdbc</b> with value <b>3.2.5</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJdbc() { return getVersion("org.springframework.boot.spring.boot.starter.data.jdbc"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

}
