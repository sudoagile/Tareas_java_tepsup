CREATE TABLE comentarios (
                             comentario_id SERIAL PRIMARY KEY,
                             contenido TEXT NOT NULL,
                             fecha_creacion DATE DEFAULT CURRENT_DATE,
                             usuario_id_fk INTEGER,
                             post_id_fk INTEGER,

                             CONSTRAINT fk_usuario_comentario FOREIGN KEY (usuario_id_fk)
                                 REFERENCES usuarios(usuario_id) ON DELETE SET NULL,

                             CONSTRAINT fk_post FOREIGN KEY (post_id_fk)
                                 REFERENCES post(post_id) ON DELETE CASCADE
);
