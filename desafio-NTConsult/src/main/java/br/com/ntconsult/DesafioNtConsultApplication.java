package br.com.ntconsult;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.ntconsult.domain.Associado;
import br.com.ntconsult.domain.Sessao;
import br.com.ntconsult.domain.Voto;
import br.com.ntconsult.enun.Valor;
import br.com.ntconsult.repository.AssociadoRepository;
import br.com.ntconsult.repository.SessaoRepository;
import br.com.ntconsult.repository.VotoRepository;

@SpringBootApplication
public class DesafioNtConsultApplication implements CommandLineRunner {

	@Autowired
	private AssociadoRepository associadoRepository;

	@Autowired
	private SessaoRepository sessaoRepository;

	@Autowired
	private VotoRepository votoRepository;

	int duracao = 10;
	String pauta = "pauta_";
	LocalDateTime dataAberturaSessao;
	Collection<Associado> listaDeAssociados;
	List<Sessao> listaDeSessaoAbertas;

	public static void main(String[] args) {
		SpringApplication.run(DesafioNtConsultApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		for (Long i = 1l; i <= 10; i++) {
			Associado a = new Associado(i, "Associado_".concat(String.valueOf(i)));
			Associado aSave = associadoRepository.save(a);
			System.out.println(aSave);
		}

		for (Long i = 1l; i <= 10; i++) {

			duracao += i;

			String pautaConcat = pauta.concat(String.valueOf(i)).concat(" Descricao: xxx");

			dataAberturaSessao = LocalDateTime.now().of(2021, Month.FEBRUARY, 6, 23, 30, 0).plusMinutes(i);

			Sessao s = new Sessao(i, pautaConcat, dataAberturaSessao, duracao);

			Sessao sSave = sessaoRepository.save(s);

			System.out.println(sSave.toString());
		}

		List<Associado> listaDeAssociados = associadoRepository.findAll();
		List<Sessao> listaDeSessoes = sessaoRepository.findAll();
		
		Long posicao;
		
		for (Long i = 1l; i <= 10; i++) {
			
			posicao = i-1;
			String posicaoString = String.valueOf(posicao);
			
			Associado associado = listaDeAssociados.get(Integer.valueOf(posicaoString));
			Sessao sessao = listaDeSessoes.get(Integer.valueOf(posicaoString));
			
			Voto voto;			

			if (i % 2 == 0) {
				voto = new Voto(i,
						new Associado(associado.getId(), associado.getNome()),
						new Sessao(sessao.getId(), sessao.getPauta(), sessao.getDataDeAbertura(), sessao.getDuracao()),
						Valor.SIM);
			} else {
				voto = new Voto(i,
						new Associado(associado.getId(), associado.getNome()),
						new Sessao(sessao.getId(), sessao.getPauta(), sessao.getDataDeAbertura(), sessao.getDuracao()),
						Valor.NAO);
			}
						
			votoRepository.save(voto);
		}

	}
}
