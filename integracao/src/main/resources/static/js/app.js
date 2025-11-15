async function buscarMensagem() {
    try {
        const response = await fetch('/api/mensagem');
        const data = await response.text();
        document.getElementById('resultado-get').innerText = data;
    } catch (error) {
        alert("Erro ao buscar mensagem: " + error);
    }
}

// Função responsável por consulta ao endpoint POST
async function enviarDados(){
    const input = document.getElementById('dados-input').value;
    if(!input) return alert("Digite algo");

    try {
        const response = await fetch('/api/dados', {
            method: 'POST',
            headers: {
                'Content-Type': 'text/plain'
            },
            body: input
        });
        const data = await response.text();
        document.getElementById('resultado-post').innerText = data;
    } catch (error) {
        alert("Erro ao enviar dados: " + error);
    }
}