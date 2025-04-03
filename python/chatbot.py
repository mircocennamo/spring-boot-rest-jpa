from chatterbot import ChatBot
from chatterbot.trainers import ListTrainer
import requests

# Configurazione del chatbot
chatbot = ChatBot('CourseBot')
trainer = ListTrainer(chatbot)

# Addestramento del chatbot con alcune frasi di esempio
trainer.train([
    "Ciao",
    "Ciao! Come posso aiutarti?",
    "Voglio creare un nuovo corso",
    "Perfetto! Qual è il nome del corso?",
    "Il nome del corso è {course_name}",
    "Qual è il livello del corso?",
    "Il livello del corso è {course_level}",
    "Grazie! Sto creando il corso per te.",
    "Quali sono i livelli disponibili?",
    "I livelli disponibili sono BASIC e ADVANCED.",
    "Come posso modificare un corso esistente?",
    "Per modificare un corso esistente, fornisci il nome del corso e i nuovi dettagli.",
    "Come posso eliminare un corso?",
    "Per eliminare un corso, fornisci il nome del corso che desideri eliminare.",
    "Quali corsi sono disponibili?",
    "Ecco l'elenco dei corsi disponibili: [elenco dei corsi].",
    "Come posso ottenere dettagli su un corso specifico?",
    "Per ottenere dettagli su un corso specifico, fornisci il nome del corso.",
    "Come posso iscrivermi a un corso?",
    "Per iscriverti a un corso, fornisci il nome del corso e i tuoi dati.",
    "Quali sono i requisiti per un corso?",
    "I requisiti per un corso dipendono dal livello e dal contenuto del corso.",
    "Posso avere una descrizione del corso?",
    "Certo, fornisci il nome del corso per avere una descrizione dettagliata.",
    "Come posso contattare l'assistenza?",
    "Puoi contattare l'assistenza via email all'indirizzo support@avanade.com.",
    "Quali sono gli orari di supporto?",
    "Gli orari di supporto sono dalle 9:00 alle 18:00 dal lunedì al venerdì.",
    "Posso avere un elenco dei corsi avanzati?",
    "Ecco l'elenco dei corsi avanzati: [elenco dei corsi avanzati].",
    "Come posso aggiornare le mie informazioni di contatto?",
    "Per aggiornare le tue informazioni di contatto, accedi al tuo profilo e modifica i dettagli.",
    "Quali sono le modalità di pagamento accettate?",
    "Accettiamo pagamenti con carta di credito, PayPal e bonifico bancario."
])

# Funzioni per invocare i servizi Spring Boot
def create_course(course_name, course_level):
    url = "http://localhost:8081/avanade/course/new"
    data = {
        "name": course_name,
        "level": course_level
    }
    response = requests.post(url, json=data)
    return response.json()

def get_all_courses():
    url = "http://localhost:8081/avanade/courses"
    response = requests.get(url)
    return response.json()

def get_course_by_id(course_id):
    url = f"http://localhost:8081/avanade/course/{course_id}"
    response = requests.get(url)
    return response.json()

def update_course(course_id, course_name, course_level):
    url = f"http://localhost:8081/avanade/course/update/{course_id}"
    data = {
        "name": course_name,
        "level": course_level
    }
    response = requests.put(url, json=data)
    return response.json()

def delete_course(course_id):
    url = f"http://localhost:8081/avanade/course/delete/{course_id}"
    response = requests.delete(url)
    return response.json()

# Simulazione di una conversazione con il chatbot
def chat_with_bot():
    print("Inizia la conversazione con il chatbot (digita 'esci' per terminare):")
    while True:
        user_input = input("Tu: ")
        if user_input.lower() == 'esci':
            break
        response = chatbot.get_response(user_input)
        print(f"Bot: {response}")

        if "nome del corso" in user_input.lower():
            course_name = input("Inserisci il nome del corso: ")
            course_level = input("Inserisci il livello del corso: ")
            result = create_course(course_name, course_level)
            print(f"Corso creato: {result}")
        elif "elenco dei corsi" in user_input.lower():
            result = get_all_courses()
            print(f"Corsi disponibili: {result}")
        elif "dettagli del corso" in user_input.lower():
            course_id = input("Inserisci l'ID del corso: ")
            result = get_course_by_id(course_id)
            print(f"Dettagli del corso: {result}")
        elif "modificare un corso" in user_input.lower():
            course_id = input("Inserisci l'ID del corso: ")
            course_name = input("Inserisci il nuovo nome del corso: ")
            course_level = input("Inserisci il nuovo livello del corso: ")
            result = update_course(course_id, course_name, course_level)
            print(f"Corso aggiornato: {result}")
        elif "eliminare un corso" in user_input.lower():
            course_id = input("Inserisci l'ID del corso: ")
            result = delete_course(course_id)
            print(f"Corso eliminato: {result}")

# Avvia la conversazione con il chatbot
chat_with_bot()