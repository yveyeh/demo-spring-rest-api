--
-- PostgreSQL database dump
--

-- Dumped from database version 15.5 (Ubuntu 15.5-0ubuntu0.23.04.1)
-- Dumped by pg_dump version 15.5 (Ubuntu 15.5-0ubuntu0.23.04.1)

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
-- Name: otp_status; Type: TYPE; Schema: public; Owner: postgres
--

CREATE TYPE public.otp_status AS ENUM (
    'VALID',
    'INVALID'
);


ALTER TYPE public.otp_status OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: doc_file; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.doc_file (
    id uuid NOT NULL,
    name character varying(255),
    size bigint,
    path character varying(255),
    description text,
    verified boolean DEFAULT false,
    verified_at timestamp without time zone DEFAULT now(),
    verification_status character varying(255) DEFAULT 'MISSING'::character varying,
    verified_by uuid,
    doc_file_type_id uuid,
    id_doc_id uuid
);


ALTER TABLE public.doc_file OWNER TO postgres;

--
-- Name: doc_file_verification; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.doc_file_verification (
    id uuid NOT NULL,
    verified_at timestamp without time zone,
    verified_by uuid,
    verification_status character varying(255),
    call_made boolean DEFAULT false,
    reject_reason_id uuid,
    doc_file_id uuid
);


ALTER TABLE public.doc_file_verification OWNER TO postgres;

--
-- Name: otp; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.otp (
    id uuid NOT NULL,
    code character varying(255),
    recipient character varying(255),
    expiry_time timestamp without time zone
);


ALTER TABLE public.otp OWNER TO postgres;

--
-- Name: question; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.question (
    id integer NOT NULL,
    question_title character varying(255),
    option1 character varying(255),
    option2 character varying(255),
    option3 character varying(255),
    option4 character varying(255),
    right_answer character varying(255),
    difficulty_level character varying(255),
    category character varying(255),
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);


ALTER TABLE public.question OWNER TO postgres;

--
-- Name: question_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.question_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.question_id_seq OWNER TO postgres;

--
-- Name: question_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.question_id_seq OWNED BY public.question.id;


--
-- Name: quiz; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.quiz (
    id integer NOT NULL,
    title character varying(255) NOT NULL
);


ALTER TABLE public.quiz OWNER TO postgres;

--
-- Name: quiz_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.quiz_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.quiz_id_seq OWNER TO postgres;

--
-- Name: quiz_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.quiz_id_seq OWNED BY public.quiz.id;


--
-- Name: quiz_questions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.quiz_questions (
    id integer NOT NULL,
    quiz_id integer,
    questions_id integer
);


ALTER TABLE public.quiz_questions OWNER TO postgres;

--
-- Name: quiz_questions_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.quiz_questions_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.quiz_questions_id_seq OWNER TO postgres;

--
-- Name: quiz_questions_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.quiz_questions_id_seq OWNED BY public.quiz_questions.id;


--
-- Name: reject_reason; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.reject_reason (
    id uuid NOT NULL,
    reason character varying(255),
    message character varying(1024)
);


ALTER TABLE public.reject_reason OWNER TO postgres;

--
-- Name: question id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.question ALTER COLUMN id SET DEFAULT nextval('public.question_id_seq'::regclass);


--
-- Name: quiz id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.quiz ALTER COLUMN id SET DEFAULT nextval('public.quiz_id_seq'::regclass);


--
-- Name: quiz_questions id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.quiz_questions ALTER COLUMN id SET DEFAULT nextval('public.quiz_questions_id_seq'::regclass);


--
-- Data for Name: doc_file; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.doc_file (id, name, size, path, description, verified, verified_at, verification_status, verified_by, doc_file_type_id, id_doc_id) FROM stdin;
89f968e3-1f07-4c6f-811d-53983f5ca866	sample_name_1	1024	/path/to/file	Example description	f	2024-05-14 10:30:00	MISSING	\N	b6e1e487-951d-4e19-b2ec-f7f7b2c785c3	34132cd4-7bb7-4f6a-89cb-3d99c57c6d1d
\.


--
-- Data for Name: doc_file_verification; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.doc_file_verification (id, verified_at, verified_by, verification_status, call_made, reject_reason_id, doc_file_id) FROM stdin;
\.


--
-- Data for Name: otp; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.otp (id, code, recipient, expiry_time) FROM stdin;
\.


--
-- Data for Name: question; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.question (id, question_title, option1, option2, option3, option4, right_answer, difficulty_level, category, created_at, updated_at) FROM stdin;
2	What is the largest mammal?	Elephant	Blue whale	Giraffe	Polar bear	Blue whale	Hard	Biology	2024-05-08 21:08:09.844307	2024-05-08 21:08:09.844307
3	What is the capital of France?	ANC	Byuiop	hjkklk	Paris	Paris	Hard	Geography	2024-05-08 22:35:49.51021	2024-05-08 22:35:49.51021
4	Which is the largest Country?	USA	Canada	China	Russia	Russia	Easy	Geography	2024-05-09 16:07:11.53095	2024-05-09 16:07:11.53095
5	What is the smallest mammal among these?	Elephant	Blue whale	Giraffe	Polar bear	Giraffe	Hard	Biology	2024-05-12 20:54:56.584319	2024-05-12 20:54:56.584319
6	What is the largest mammal?	Elephant	Blue whale	Giraffe	Polar goat	Blue whale	Hard	Biology	2024-05-14 05:00:48.055231	2024-05-14 05:00:48.055231
\.


--
-- Data for Name: quiz; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.quiz (id, title) FROM stdin;
2	Animal Quiz
\.


--
-- Data for Name: quiz_questions; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.quiz_questions (id, quiz_id, questions_id) FROM stdin;
1	2	2
2	2	5
\.


--
-- Data for Name: reject_reason; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.reject_reason (id, reason, message) FROM stdin;
\.


--
-- Name: question_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.question_id_seq', 6, true);


--
-- Name: quiz_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.quiz_id_seq', 2, true);


--
-- Name: quiz_questions_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.quiz_questions_id_seq', 2, true);


--
-- Name: doc_file doc_file_new_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.doc_file
    ADD CONSTRAINT doc_file_new_pkey PRIMARY KEY (id);


--
-- Name: doc_file_verification doc_file_verification_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.doc_file_verification
    ADD CONSTRAINT doc_file_verification_pkey PRIMARY KEY (id);


--
-- Name: otp otp_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.otp
    ADD CONSTRAINT otp_pkey PRIMARY KEY (id);


--
-- Name: question question_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.question
    ADD CONSTRAINT question_pkey PRIMARY KEY (id);


--
-- Name: quiz quiz_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.quiz
    ADD CONSTRAINT quiz_pkey PRIMARY KEY (id);


--
-- Name: quiz_questions quiz_questions_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.quiz_questions
    ADD CONSTRAINT quiz_questions_pkey PRIMARY KEY (id);


--
-- Name: reject_reason reject_reason_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reject_reason
    ADD CONSTRAINT reject_reason_pkey PRIMARY KEY (id);


--
-- Name: doc_file_verification doc_file_verification_doc_file_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.doc_file_verification
    ADD CONSTRAINT doc_file_verification_doc_file_id_fkey FOREIGN KEY (doc_file_id) REFERENCES public.doc_file(id);


--
-- Name: doc_file_verification doc_file_verification_reject_reason_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.doc_file_verification
    ADD CONSTRAINT doc_file_verification_reject_reason_id_fkey FOREIGN KEY (reject_reason_id) REFERENCES public.reject_reason(id);


--
-- Name: quiz_questions quiz_questions_question_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.quiz_questions
    ADD CONSTRAINT quiz_questions_question_id_fkey FOREIGN KEY (questions_id) REFERENCES public.question(id);


--
-- Name: quiz_questions quiz_questions_quiz_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.quiz_questions
    ADD CONSTRAINT quiz_questions_quiz_id_fkey FOREIGN KEY (quiz_id) REFERENCES public.quiz(id);


--
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: pg_database_owner
--

GRANT ALL ON SCHEMA public TO demodb_user;


--
-- Name: TABLE doc_file; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.doc_file TO demodb_user;


--
-- Name: TABLE doc_file_verification; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.doc_file_verification TO demodb_user;


--
-- Name: TABLE otp; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.otp TO demodb_user;


--
-- Name: TABLE question; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public.question TO PUBLIC;
GRANT ALL ON TABLE public.question TO demodb_user;


--
-- Name: SEQUENCE question_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,USAGE ON SEQUENCE public.question_id_seq TO demodb_user;
GRANT SELECT,USAGE ON SEQUENCE public.question_id_seq TO PUBLIC;


--
-- Name: TABLE quiz; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.quiz TO demodb_user;


--
-- Name: SEQUENCE quiz_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,USAGE ON SEQUENCE public.quiz_id_seq TO demodb_user;


--
-- Name: TABLE quiz_questions; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.quiz_questions TO demodb_user;


--
-- Name: SEQUENCE quiz_questions_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,USAGE ON SEQUENCE public.quiz_questions_id_seq TO demodb_user;


--
-- Name: TABLE reject_reason; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.reject_reason TO demodb_user;


--
-- PostgreSQL database dump complete
--

