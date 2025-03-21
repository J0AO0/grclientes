package com.grclientes.security.resource;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

public @interface CheckSecurity {

    public @interface Usuario {

        @PreAuthorize("hasAuthority('C_USU')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface PodeCadastrar {}

        @PreAuthorize("hasAuthority('D_USU')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface PodeExcluir {}

        @PreAuthorize("hasAuthority('U_USU')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface PodeAtualizar {}

        @PreAuthorize("hasAuthority('R_USU')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface PodeConsultar {}

        @PreAuthorize("hasAuthority('S_USU')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface PodeAlterarStatus {}

    }

    public @interface Pedido {

        @PreAuthorize("hasAuthority('C_PED')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface PodeCadastrar {}

        @PreAuthorize("hasAuthority('D_PED')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface PodeExcluir {}

        @PreAuthorize("hasAuthority('U_PED')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface PodeAtualizar {}

        @PreAuthorize("hasAuthority('R_PED')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface PodeConsultar {}

        @PreAuthorize("hasAuthority('S_PED')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface PodeAlterarStatus {}

    }

    public @interface Produto {

        @PreAuthorize("hasAuthority('C_PROD')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface PodeCadastrar {}

        @PreAuthorize("hasAuthority('D_PROD')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface PodeExcluir {}

        @PreAuthorize("hasAuthority('U_PROD')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface PodeAtualizar {}

        @PreAuthorize("hasAuthority('R_PROD')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface PodeConsultar {}

        @PreAuthorize("hasAuthority('S_PROD')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface PodeAlterarStatus {}

    }

    public @interface Empresa {

        @PreAuthorize("hasAuthority('C_EMP')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface PodeCadastrar {}

        @PreAuthorize("hasAuthority('D_EMP')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface PodeExcluir {}

        @PreAuthorize("hasAuthority('U_EMP')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface PodeAtualizar {}

        @PreAuthorize("hasAuthority('R_EMP')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface PodeConsultar {}

        @PreAuthorize("hasAuthority('S_EMP')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface PodeAlterarStatus {}

    }

    public @interface Arquiteto {

        @PreAuthorize("hasAuthority('C_ARQ')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface PodeCadastrar {}

        @PreAuthorize("hasAuthority('D_ARQ')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface PodeExcluir {}

        @PreAuthorize("hasAuthority('U_ARQ')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface PodeAtualizar {}

        @PreAuthorize("hasAuthority('R_ARQ')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface PodeConsultar {}

        @PreAuthorize("hasAuthority('S_ARQ')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface PodeAlterarStatus {}

    }    public @interface Vendedor {

        @PreAuthorize("hasAuthority('C_VEND')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface PodeCadastrar {}

        @PreAuthorize("hasAuthority('D_VEND')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface PodeExcluir {}

        @PreAuthorize("hasAuthority('U_VEND')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface PodeAtualizar {}

        @PreAuthorize("hasAuthority('R_VEND')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface PodeConsultar {}

        @PreAuthorize("hasAuthority('S_VEND')")
        @Retention(RUNTIME)
        @Target(METHOD)
        public @interface PodeAlterarStatus {}

    }

}
