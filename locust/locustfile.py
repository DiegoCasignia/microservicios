from locust import HttpUser, task, between
import random

class PublicacionUser(HttpUser):
    host = "http://localhost:8080"

    wait_time = between(0.5, 1.5)  # Tiempo entre peticiones

    @task
    def crear_libro(self):
        autor_id = 1

        payload = {
            "titulo": f"Libro Aleatorio {random.randint(1000, 9999)}",
            "añoPublicacion": 2023,
            "editorial": "Editorial Ejemplo",
            "isbn": f"ISBN{random.randint(1000000000000, 9999999999999)}",
            "resumen": "Resumen del libro de prueba.",
            "genero": "Ciencia Ficción",
            "numeroPaginas": 300,
            "autorId": autor_id
        }

        self.client.post("/libros", json=payload)