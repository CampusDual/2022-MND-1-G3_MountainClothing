--
-- PostgreSQL database dump
--

-- Dumped from database version 11.16 (Debian 11.16-0+deb10u1)
-- Dumped by pg_dump version 14.2

-- Started on 2023-02-02 11:08:22

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--DROP DATABASE "Master_UDC_2022_G3";
--
-- TOC entry 2977 (class 1262 OID 204969)
-- Name: Master_UDC_2022_G3; Type: DATABASE; Schema: -; Owner: -
--

--CREATE DATABASE "Master_UDC_2022_G3" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'en_US.UTF-8';


\connect "Master_UDC_2022_G3"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: -
--

--CREATE SCHEMA public;


--
-- TOC entry 2978 (class 0 OID 0)
-- Dependencies: 3
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

--
-- TOC entry 197 (class 1259 OID 205285)
-- Name: contacts; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.contacts (
    id integer NOT NULL,
    email character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    phone integer NOT NULL,
    surname1 character varying(255) NOT NULL,
    surname2 character varying(255) NOT NULL
);


--
-- TOC entry 196 (class 1259 OID 205283)
-- Name: contacts_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.contacts_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2979 (class 0 OID 0)
-- Dependencies: 196
-- Name: contacts_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.contacts_id_seq OWNED BY public.contacts.id;


--
-- TOC entry 207 (class 1259 OID 205789)
-- Name: prendas_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.prendas_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 206 (class 1259 OID 205706)
-- Name: prendas; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.prendas (
    id integer DEFAULT nextval('public.prendas_id_seq'::regclass) NOT NULL,
    color character varying(255) NOT NULL,
    nombre character varying(255) NOT NULL,
    precio integer NOT NULL,
    prendas character varying(255) NOT NULL,
    sexo character varying(255) NOT NULL,
    tallas character varying(255) NOT NULL,
    unidades integer NOT NULL
);


--
-- TOC entry 199 (class 1259 OID 205296)
-- Name: profiles; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.profiles (
    id integer NOT NULL,
    description character varying(255),
    name character varying(255)
);


--
-- TOC entry 198 (class 1259 OID 205294)
-- Name: profiles_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.profiles_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2980 (class 0 OID 0)
-- Dependencies: 198
-- Name: profiles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.profiles_id_seq OWNED BY public.profiles.id;


--
-- TOC entry 200 (class 1259 OID 205305)
-- Name: profiles_sections_map; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.profiles_sections_map (
    profile_id integer NOT NULL,
    section_id integer NOT NULL
);


--
-- TOC entry 202 (class 1259 OID 205310)
-- Name: sections; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.sections (
    id integer NOT NULL,
    alias character varying(255),
    description character varying(255),
    name character varying(255)
);


--
-- TOC entry 201 (class 1259 OID 205308)
-- Name: sections_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.sections_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2981 (class 0 OID 0)
-- Dependencies: 201
-- Name: sections_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.sections_id_seq OWNED BY public.sections.id;


--
-- TOC entry 204 (class 1259 OID 205327)
-- Name: users; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.users (
    id integer NOT NULL,
    login character varying(255),
    name character varying(255),
    nif character varying(255),
    password character varying(255),
    surname1 character varying(255),
    surname2 character varying(255)
);


--
-- TOC entry 203 (class 1259 OID 205325)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2982 (class 0 OID 0)
-- Dependencies: 203
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- TOC entry 205 (class 1259 OID 205342)
-- Name: users_profiles_map; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.users_profiles_map (
    user_id integer NOT NULL,
    profile_id integer NOT NULL
);


--
-- TOC entry 2812 (class 2604 OID 205288)
-- Name: contacts id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.contacts ALTER COLUMN id SET DEFAULT nextval('public.contacts_id_seq'::regclass);


--
-- TOC entry 2813 (class 2604 OID 205299)
-- Name: profiles id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.profiles ALTER COLUMN id SET DEFAULT nextval('public.profiles_id_seq'::regclass);


--
-- TOC entry 2814 (class 2604 OID 205313)
-- Name: sections id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.sections ALTER COLUMN id SET DEFAULT nextval('public.sections_id_seq'::regclass);


--
-- TOC entry 2815 (class 2604 OID 205330)
-- Name: users id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- TOC entry 2961 (class 0 OID 205285)
-- Dependencies: 197
-- Data for Name: contacts; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.contacts VALUES (1, 'kdisldk', 'lsodkcm', 124356, 'mandjs', 'kamdjdn');


--
-- TOC entry 2970 (class 0 OID 205706)
-- Dependencies: 206
-- Data for Name: prendas; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.prendas VALUES (9, 'Gris', 'Sudadera Bordado Randy''s Donuts', 30, 'Capucha incluida', 'Hombre', 'M', 3);
INSERT INTO public.prendas VALUES (10, 'Negro', 'Sudadera Bordado Randy''s Donuts', 25, 'Sin capucha', 'Hombre', 'M', 4);
INSERT INTO public.prendas VALUES (11, 'Crema', 'Camisa Denim', 20, 'Manga larga', 'Mujer', 'S', 6);
INSERT INTO public.prendas VALUES (12, 'Turquesa', 'Camisa Oxford', 30, 'Sin mangas', 'Mujer', 'L', 5);
INSERT INTO public.prendas VALUES (13, 'Negro', 'Chaleco Jacquard ', 40, 'Limited Edition', 'Mujer', 'M', 4);
INSERT INTO public.prendas VALUES (14, 'Caoba', 'Camiseta Cuello Rib', 30, 'Limited Edition', 'Hombre', 'S', 3);
INSERT INTO public.prendas VALUES (15, 'Azul', 'Camiseta Cuello Rib', 20, 'Edición standard', 'Hombre', 'L', 4);
INSERT INTO public.prendas VALUES (16, 'Gris', 'Camiseta Oversize', 45, 'Logo Francia', 'Mujer', 'M', 6);
INSERT INTO public.prendas VALUES (21, 'Mujer', 'Camisa prueba', 30, 'manga larga', 'azul', 'M', 50);


--
-- TOC entry 2963 (class 0 OID 205296)
-- Dependencies: 199
-- Data for Name: profiles; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.profiles VALUES (2, 'Acceso dependiente', 'Dependiente');
INSERT INTO public.profiles VALUES (1, 'Acceso general', 'Administrador');
INSERT INTO public.profiles VALUES (3, 'Acceso gerente', 'Gerente');


--
-- TOC entry 2964 (class 0 OID 205305)
-- Dependencies: 200
-- Data for Name: profiles_sections_map; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.profiles_sections_map VALUES (1, 1);
INSERT INTO public.profiles_sections_map VALUES (2, 2);
INSERT INTO public.profiles_sections_map VALUES (3, 3);
INSERT INTO public.profiles_sections_map VALUES (1, 2);
INSERT INTO public.profiles_sections_map VALUES (1, 3);
INSERT INTO public.profiles_sections_map VALUES (2, 4);
INSERT INTO public.profiles_sections_map VALUES (1, 4);
INSERT INTO public.profiles_sections_map VALUES (3, 2);


--
-- TOC entry 2966 (class 0 OID 205310)
-- Dependencies: 202
-- Data for Name: sections; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.sections VALUES (1, 'CONTACTS', 'Perfiles y secciones a los que puede acceder cada perfil.', 'Contactos');
INSERT INTO public.sections VALUES (4, 'HOME', 'Ventana HOME', 'HOME');
INSERT INTO public.sections VALUES (2, 'PRENDAS', 'Numero de prendas por tienda', 'prendas');
INSERT INTO public.sections VALUES (3, 'STOCKS', 'Modificación del número de prendas', 'stocks');


--
-- TOC entry 2968 (class 0 OID 205327)
-- Dependencies: 204
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.users VALUES (4, 'Dependiente/Noelia', 'Noelia', '34567890N', 'rz/3rp5MhsEwsCXKogqpygxFTlSaWft501CoCwTVe2U=', 'Amoedo', 'Abilleira');
INSERT INTO public.users VALUES (5, 'Gerente/JoseLuis', 'Jose Luis', '12345687J', '85i39JmowUpQ7Hou8l7sqzEw2rgdwVgbs7ZEzShJdQI=', 'López', 'Mosteiro');
INSERT INTO public.users VALUES (1, 'demo', 'Demo', '', 'C5rCRzh9s2DPHYrnnLS/eg==', 'demo', '');
INSERT INTO public.users VALUES (2, 'Dependiente/Christian', 'Christian', '12345678C', 'JRxaSgOz90P9mYqcTMT4kwWyahzn3253PtRBDBEvx20=', 'Mallo', 'Vázquez');
INSERT INTO public.users VALUES (3, 'Dependiente/Luis', 'Luis', '23456789L', 'In62V7hzS0q9CY55qxt0swKi7X2vrGZS2mjwx48wkKA=', 'Cuesta', 'Espiñeira');


--
-- TOC entry 2969 (class 0 OID 205342)
-- Dependencies: 205
-- Data for Name: users_profiles_map; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.users_profiles_map VALUES (1, 1);
INSERT INTO public.users_profiles_map VALUES (2, 2);
INSERT INTO public.users_profiles_map VALUES (3, 2);
INSERT INTO public.users_profiles_map VALUES (4, 2);
INSERT INTO public.users_profiles_map VALUES (5, 3);


--
-- TOC entry 2983 (class 0 OID 0)
-- Dependencies: 196
-- Name: contacts_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.contacts_id_seq', 1, true);


--
-- TOC entry 2984 (class 0 OID 0)
-- Dependencies: 207
-- Name: prendas_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.prendas_id_seq', 21, true);


--
-- TOC entry 2985 (class 0 OID 0)
-- Dependencies: 198
-- Name: profiles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.profiles_id_seq', 1, true);


--
-- TOC entry 2986 (class 0 OID 0)
-- Dependencies: 201
-- Name: sections_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.sections_id_seq', 1, true);


--
-- TOC entry 2987 (class 0 OID 0)
-- Dependencies: 203
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.users_id_seq', 2, true);


--
-- TOC entry 2818 (class 2606 OID 205293)
-- Name: contacts contacts_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.contacts
    ADD CONSTRAINT contacts_pkey PRIMARY KEY (id);


--
-- TOC entry 2834 (class 2606 OID 205737)
-- Name: prendas prendas_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.prendas
    ADD CONSTRAINT prendas_pk PRIMARY KEY (id);


--
-- TOC entry 2822 (class 2606 OID 205304)
-- Name: profiles profiles_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.profiles
    ADD CONSTRAINT profiles_pkey PRIMARY KEY (id);


--
-- TOC entry 2824 (class 2606 OID 205320)
-- Name: sections sections_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.sections
    ADD CONSTRAINT sections_pkey PRIMARY KEY (id);


--
-- TOC entry 2826 (class 2606 OID 205361)
-- Name: sections uk_3hhqmvx0pt70xjvmjdo5a76go; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.sections
    ADD CONSTRAINT uk_3hhqmvx0pt70xjvmjdo5a76go UNIQUE (alias);


--
-- TOC entry 2820 (class 2606 OID 205357)
-- Name: contacts uk_9mg1wlguu09et002069e9qeum; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.contacts
    ADD CONSTRAINT uk_9mg1wlguu09et002069e9qeum UNIQUE (phone);


--
-- TOC entry 2828 (class 2606 OID 205365)
-- Name: users uk_ow0gan20590jrb00upg3va2fn; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT uk_ow0gan20590jrb00upg3va2fn UNIQUE (login);


--
-- TOC entry 2830 (class 2606 OID 205341)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 2832 (class 2606 OID 205346)
-- Name: users_profiles_map users_profiles_map_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users_profiles_map
    ADD CONSTRAINT users_profiles_map_pkey PRIMARY KEY (user_id, profile_id);


--
-- TOC entry 2838 (class 2606 OID 205381)
-- Name: users_profiles_map fkgu8qveimyui706fn78n4xbenf; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users_profiles_map
    ADD CONSTRAINT fkgu8qveimyui706fn78n4xbenf FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- TOC entry 2835 (class 2606 OID 205366)
-- Name: profiles_sections_map fkkqferkfgrrnho62b21rya9ej9; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.profiles_sections_map
    ADD CONSTRAINT fkkqferkfgrrnho62b21rya9ej9 FOREIGN KEY (section_id) REFERENCES public.sections(id);


--
-- TOC entry 2836 (class 2606 OID 205371)
-- Name: profiles_sections_map fknbjkd2pgwcyijblewp1d33rox; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.profiles_sections_map
    ADD CONSTRAINT fknbjkd2pgwcyijblewp1d33rox FOREIGN KEY (profile_id) REFERENCES public.profiles(id);


--
-- TOC entry 2837 (class 2606 OID 205376)
-- Name: users_profiles_map fksv94wyv9yb3b2hmvr5f48o281; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.users_profiles_map
    ADD CONSTRAINT fksv94wyv9yb3b2hmvr5f48o281 FOREIGN KEY (profile_id) REFERENCES public.profiles(id);


-- Completed on 2023-02-02 11:08:24

--
-- PostgreSQL database dump complete
--

