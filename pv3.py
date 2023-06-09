import threading
import subprocess
import time
import matplotlib.pyplot as plt


# lista de comandos de red a ejecutar
comandos_red = ["ping google.com", "ping facebook.com", "arp /a", "ipconfig", "netstat", "hostname", "tracert google.com","getmac","nslookup facebook.com","nbtstat /n","pathping openwebinars.net","route PRINT","netsh int ip reset","nbtstat -c","pathping google.com","nslookup youtube.com","nbtstat /c","netstat -e -s","netstat -n -o","nbtstat –r"]


# lista para almacenar los tiempos de ejecución
tiempos_ejecucion = []



def ejecutar_comando(comando):
    # ejecutar el comando de red
    inicio = time.time()
    subprocess.run(comando, shell=True)
    fin = time.time()
    # calcular el tiempo de ejecución y almacenarlo en la lista
    tiempo_ejecucion = fin - inicio
    tiempos_ejecucion.append(tiempo_ejecucion)
    print("\ntiempo de ejecucion", tiempo_ejecucion,"\n")

# crear un hilo de ejecución para cada comando de red
hilos = []
for comando in comandos_red:
    hilo = threading.Thread(target=ejecutar_comando, args=(comando,))
    hilos.append(hilo)

# iniciar todos los hilos de ejecución
for hilo in hilos:
    hilo.start()

# esperar a que todos los hilos de ejecución terminen
for hilo in hilos:
    hilo.join()

n = 4
final = [tiempos_ejecucion[i * n:(i+1) * n] for i in range((len(tiempos_ejecucion) + n - 1) // n)]
final_comando = [comandos_red[i * n:(i+1) * n] for i in range((len(comandos_red) + n - 1) // n)]


# graficar los tiempos de ejecución
for idx, list in enumerate(final):
    plt.bar(final_comando[idx], list)
    #plt.legend()
    plt.xlabel('Comando')
    plt.ylabel('Tiempo de ejecución (segundos)')
    plt.title('Tiempos de ejecución de comandos de red')
    plt.show()