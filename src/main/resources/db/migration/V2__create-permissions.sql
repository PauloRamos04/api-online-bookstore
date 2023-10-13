-- Permissions
ALTER TABLE public.administradores OWNER TO bookstore;
GRANT ALL ON TABLE public.administradores TO bookstore;

ALTER TABLE public.autores OWNER TO bookstore;
GRANT ALL ON TABLE public.autores TO bookstore;

ALTER TABLE public.editoras OWNER TO bookstore;
GRANT ALL ON TABLE public.editoras TO bookstore;

ALTER TABLE public.flyway_schema_history OWNER TO bookstore;
GRANT ALL ON TABLE public.flyway_schema_history TO bookstore;

ALTER TABLE public.usuarios OWNER TO bookstore;
GRANT ALL ON TABLE public.usuarios TO bookstore;

ALTER TABLE public.livros OWNER TO bookstore;
GRANT ALL ON TABLE public.livros TO bookstore;

ALTER TABLE public.moderacao OWNER TO bookstore;
GRANT ALL ON TABLE public.moderacao TO bookstore;
