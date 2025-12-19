      const telaIncluir = document.getElementById('tela-incluir');
        const telaAlterar = document.getElementById('tela-alterar');
        
        if (telaIncluir){
            telaIncluir.style.display = 'none';
        }
        if (telaAlterar){
            telaAlterar.style.display = 'none';
        }
        

        const botaoIncluir = document.getElementById('btn-incluir');
        const botaoAlterar = document.getElementById('btn-alterar');
        const botaoExcluir = document.getElementById('btn-excluir');

        const botaoSairTelaIncluir = document.getElementById('btn-sair-incluir');

        const botaoSairTelaAlterar = document.getElementById('btn-sair-alterar');

        function abrirTelaIncluir() {
            telaIncluir.style.display = 'block';
        }
        function fecharTelaIncluir() {
            telaIncluir.style.display = 'none';
        }

        botaoIncluir.addEventListener("click",abrirTelaIncluir());
        
        function abrirTelaAlterar() {
            const linhaSelecionada = document.querySelector('#tabela tr.selected');
            if (!linhaSelecionada) {
                alert('Selecione uma linha antes de alterar');
                return;
            }
            const cells = linhaSelecionada.getElementsByTagName('td');
            const vencimento = cells[1]? cells[1].textContent.trim() : '';
            const empresa = cells[2]? cells[2].textContent.trim() : '';
            const valor = cells[3]? cells[3].textContent.trim() : '';

            function formatDateForInput(ddmmyyyy) {
                if (!ddmmyyyy) return '';
                const parts = ddmmyyyy.split('/');
                if (parts.length !== 3) return '';
                return parts.length === 3 ? `${parts[2]}-${parts[1]}-${parts[0]}` : '';
            }

            document.getElementById('input-Vencimento').value = formatDateForInput(vencimento);
            document.getElementById('input-Empresa').value = empresa;
            document.getElementById('input-Valor').value = valor;

            telaAlterar.style.display = 'block';
        }
        function fecharTelaAlterar() {
            telaAlterar.style.display = 'none';
        }

        function msgErro() {
            alert("Em breve! O site ainda está em desenvolvimento");
        }
        /*tela incluir*/
        const inputData = document.getElementById('input-data');
        const inputEmpresa = document.getElementById('input-empresa');
        const inputValor = document.getElementById('input-valor');

        function campoVazioMsg() {

            if (inputData.value.trim() === "" || inputEmpresa.value.trim() === "" || inputValor.value.trim() === "") {
                alert("preencha todos os campos antes de salvar!");
                return true;
            } return false;
        }

function buscar() {
    var input = document.getElementById('input');
    var filter = input.value.toUpperCase();           // <-- toUpperCase()
    var table = document.getElementById('tabela');
    var tr = table.getElementsByTagName("tr");

    for (var i = 0; i < tr.length; i++) {
      var td = tr[i].getElementsByTagName('td')[0];
      if (td) {
        var txtValue = td.textContent || td.innerText;
        // usar toUpperCase() na string também
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
          tr[i].style.display = "";
        } else {
          tr[i].style.display = "none";
        }
      }
    }
  }

/*Selecionar linha*/
        const tabela = document.getElementById ('tabela');
        for (const linha of tabela.getElementsByTagName('tr')) {
            linha.addEventListener('click', function() {
                const anterior = tabela.querySelector('.selected');
                if (anterior) anterior.classList.remove('selected');

                this.classList.add('selected');
            });
        }
/*excluir linha*/
        document.getElementById('btn-excluir').addEventListener('click', function() {
            const linhaSelecionada = document.querySelector('#tabela tr.selected');
            
            if (linhaSelecionada) {
                
                if (confirm ("Tem certeza de que deseja excluir permanentemente o Registro?")){
                linhaSelecionada.remove();
                atualizarStorage();
            }
            } else {
                alert('Selecione uma linha antes de excluir');
            }
        } );


        /*incluir*/
        const tableBody = document.querySelector('#tabela tbody');
        const nameInput = document.getElementById('input-empresa');
        const dateInput = document.getElementById('input-data');
        const valueInput = document.getElementById('input-valor');
        const saveButton = document.getElementById('btn-salvar-incluir');

        saveButton.addEventListener('click', addRowFromInput);

        function getNextId() {
            const lastIdCell = tableBody.querySelector('tr:last-child td:first-child');
            const last = lastIdCell ? parseInt(lastIdCell.textContent, 10) : 0;
            return last + 1;
        }

        function formatDateInput(isoDate) {
            if (!isoDate) return '';
            // input type=date entrega yyyy-mm-dd; converte para dd/mm/yyyy
            const parts = isoDate.split('-');
            return parts.length === 3 ? `${parts[2]}/${parts[1]}/${parts[0]}` : isoDate;
        }

        function addRowFromInput(event) {
            

            // valida campos
            if (campoVazioMsg()) return;

            const id = getNextId();
            const name = nameInput.value.trim();
            const date = formatDateInput(dateInput.value.trim());
            const value = valueInput.value.trim();

            // cria linha com a mesma ordem do <thead>: ID, Vencimento, Empresa, Valor
            const newRow = document.createElement('tr');

            const idCell = document.createElement('td');
            idCell.textContent = id;
            newRow.appendChild(idCell);

            const dateCell = document.createElement('td');
            dateCell.textContent = date;
            newRow.appendChild(dateCell);

            const nameCell = document.createElement('td');
            nameCell.textContent = name;
            newRow.appendChild(nameCell);

            const valueCell = document.createElement('td');
            valueCell.textContent = value;
            newRow.appendChild(valueCell);

            tableBody.appendChild(newRow);

            newRow.addEventListener('click', function() {
                const anterior = tabela.querySelector('.selected');
                if (anterior) anterior.classList.remove('selected');

                this.classList.add('selected');
            });

            // limpa e fecha tela de incluir
            nameInput.value = '';
            dateInput.value = '';
            valueInput.value = '';

            fecharTelaIncluir();
        
        }

        const btnSalvarAlterar = document.getElementById('btn-salvar-alterar');
        /*alterar*/
        (function() {
            const formAlterar = document.querySelector('#tela-alterar form');
            if (!formAlterar) return;

            function isoToDisplayDate(isoDate) {
                if (!formAlterar) return '';
                const parts = isoDate.split('-');
                return parts.length === 3 ? `${parts[2]}/${parts[1]}/${parts[0]}` : isoDate;
            }
            btnSalvarAlterar.addEventListener('click', function(e) {
                e.preventDefault();
                const linhaSelecionada = document.querySelector('#tabela tr.selected');
                if (!linhaSelecionada) {
                    alert('Selecione uma linha antes de salvar a alteração.');
                    fecharTelaAlterar();
                    return;
                }

                const cells = linhaSelecionada.getElementsByTagName('td');

                const novoVenc = isoToDisplayDate(document.getElementById('input-Vencimento').value.trim());
                const novaEmpresa = document.getElementById('input-Empresa').value.trim();
                const novoValor = document.getElementById('input-Valor').value.trim();

                if (!novoVenc || !novaEmpresa || !novoValor) {
                    alert('Preencha todos os campos antes de salvar!');
                    return;
                }

                if (cells[1]) cells[1].textContent = novoVenc;
                if (cells[2]) cells[2].textContent = novaEmpresa;
                if (cells[3]) cells[3].textContent = novoValor;

                    if(typeof atualizarStorage === 'function') atualizarStorage();

                    fecharTelaAlterar();
            });
            
        })();
