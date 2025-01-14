PGDMP                         z         
   BDproyecto    15.0    15.0                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            	           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            
           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16449 
   BDproyecto    DATABASE     �   CREATE DATABASE "BDproyecto" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Colombia.1252';
    DROP DATABASE "BDproyecto";
                postgres    false            �            1259    16465    facturas    TABLE     �   CREATE TABLE public.facturas (
    idcliente integer NOT NULL,
    idfactura integer NOT NULL,
    precio integer DEFAULT 0 NOT NULL,
    fecha text NOT NULL,
    descripcion text NOT NULL
);
    DROP TABLE public.facturas;
       public         heap    postgres    false            �            1259    16464    facturas_idfactura_seq    SEQUENCE     �   ALTER TABLE public.facturas ALTER COLUMN idfactura ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.facturas_idfactura_seq
    START WITH 100
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    217            �            1259    16450 	   productos    TABLE     �   CREATE TABLE public.productos (
    id integer NOT NULL,
    nombre text NOT NULL,
    inventario integer NOT NULL,
    precio numeric NOT NULL,
    importacion date NOT NULL
);
    DROP TABLE public.productos;
       public         heap    postgres    false            �            1259    16455    trabajadores    TABLE     �   CREATE TABLE public.trabajadores (
    cedula text NOT NULL,
    nombre text NOT NULL,
    apellido text NOT NULL,
    telefono text NOT NULL,
    nacimiento date NOT NULL,
    direccion text NOT NULL,
    password text NOT NULL
);
     DROP TABLE public.trabajadores;
       public         heap    postgres    false                      0    16465    facturas 
   TABLE DATA           T   COPY public.facturas (idcliente, idfactura, precio, fecha, descripcion) FROM stdin;
    public          postgres    false    217   ^                 0    16450 	   productos 
   TABLE DATA           P   COPY public.productos (id, nombre, inventario, precio, importacion) FROM stdin;
    public          postgres    false    214   {                 0    16455    trabajadores 
   TABLE DATA           k   COPY public.trabajadores (cedula, nombre, apellido, telefono, nacimiento, direccion, password) FROM stdin;
    public          postgres    false    215   �                  0    0    facturas_idfactura_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.facturas_idfactura_seq', 100, false);
          public          postgres    false    216            s           2606    16472    facturas facturas_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.facturas
    ADD CONSTRAINT facturas_pkey PRIMARY KEY (idfactura);
 @   ALTER TABLE ONLY public.facturas DROP CONSTRAINT facturas_pkey;
       public            postgres    false    217            o           2606    16461    productos productos_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.productos
    ADD CONSTRAINT productos_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.productos DROP CONSTRAINT productos_pkey;
       public            postgres    false    214            q           2606    16463    trabajadores tabajadores_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.trabajadores
    ADD CONSTRAINT tabajadores_pkey PRIMARY KEY (cedula);
 G   ALTER TABLE ONLY public.trabajadores DROP CONSTRAINT tabajadores_pkey;
       public            postgres    false    215                  x������ � �         U   x�M̱	�@D�x����Y,@�0�c1SP�G3������p���T���HƼ��r�����Qѣ-瞠����͝�=ڂ         S   x�3444307040�tI��L���M,*,M��46437��47��4200�54�50�tN��IU02UP64�52�442�������  ��     