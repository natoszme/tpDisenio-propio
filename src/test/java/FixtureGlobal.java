import java.util.ArrayList;

public class FixtureGlobal {
	
	Categoria r1, r2, r3, r4, r8, r9;
	Usuario nico, pepe, lio;
	Dispositivo tv, aire, homeTheater;
	
	public FixtureGlobal(){
		r1 = new Categoria("r1", 0, 150, 18.76, 0.644);
		r2 = new Categoria("r2", 150, 325, 35.32, 0.644);
		r3 = new Categoria("r3", 325, 400, 60.71, 0.681);
		r4 = new Categoria("r4", 400, 450, 71.74, 0.738);
		r8 = new Categoria("r8", 700, 1400, 545.96, 0.851);
		r9 = new Categoria("r9", 1400, Double.MAX_VALUE, 887.19, 0.851);
		nico = new Usuario("nico", "otamendi", TIPO_DOCUMENTO.DNI, 35102594, 42012594, "Av. Siempre Viva 20", r1, new ArrayList<Dispositivo>());
		pepe = new Usuario("pepe", "argento", TIPO_DOCUMENTO.CI, 12549785, 40000001, "Manuel Rodriguez 1251", r1, new ArrayList<Dispositivo>());
		lio = new Usuario("lio", "messi", TIPO_DOCUMENTO.DNI, 40216458, 10101010, "Av. Catalunia 10", r2, new ArrayList<Dispositivo>());
		tv = new Dispositivo("tv", 12, true, 10);
		aire = new Dispositivo("aire", 80, false, 2);
		homeTheater = new Dispositivo("home theater", 100, true, 1);
	}
}
