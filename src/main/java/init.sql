CREATE TABLE IF NOT EXISTS public."Homework"
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    name text COLLATE pg_catalog."default" NOT NULL,
    description text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "Homework_pkey" PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."Homework"
    OWNER to postgres;

-- Table: public.Lesson

-- DROP TABLE IF EXISTS public."Lesson";

CREATE TABLE IF NOT EXISTS public."Lesson"
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY (INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 )
    name text COLLATE pg_catalog."default" NOT NULL,
    "updatedAt" time with time zone NOT NULL,
    homework_id integer NOT NULL,
    CONSTRAINT "Lesson_pkey" PRIMARY KEY (id),
    CONSTRAINT fk_homework_ FOREIGN KEY (id)
        REFERENCES public."Homework" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."Lesson"
    OWNER to postgres;

-- Table: public.Schedule

-- DROP TABLE IF EXISTS public."Schedule";

CREATE TABLE IF NOT EXISTS public."Schedule"
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    name text COLLATE pg_catalog."default" NOT NULL,
    "updatedAt" bigint NOT NULL,
    lessons bigint NOT NULL,
    CONSTRAINT "Schedule_pkey" PRIMARY KEY (id),
    CONSTRAINT fk_lesson FOREIGN KEY (id)
        REFERENCES public."Lesson" (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."Schedule"
    OWNER to postgres;
