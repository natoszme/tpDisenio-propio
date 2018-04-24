import java.util.ArrayList;

public class FixtureGlobal {
	Categoria r1 = new CategoriaSinMinimo("r1", 0, 150, 18.76, 0.644);
	Categoria r2 = new Categoria("r2", 150, 325, 35.32, 0.644);
	Categoria r3 = new Categoria("r3", 325, 400, 60.71, 0.681);
	Categoria r4 = new Categoria("r4", 400, 450, 71.74, 0.738);
	Usuario nico = new Usuario("nico", "otamendi", TIPO_DOCUMENTO.DNI, 35102594, 42012594, "Av. Siempre Viva 20", r1, new ArrayList<Dispositivo>());
	Usuario pepe = new Usuario("pepe", "argento", TIPO_DOCUMENTO.CI, 12549785, 40000001, "Manuel Rodriguez 1251", r1, new ArrayList<Dispositivo>());
	Usuario lio = new Usuario("lio", "messi", TIPO_DOCUMENTO.DNI, 40216458, 10101010, "Av. Catalunia 10", r2, new ArrayList<Dispositivo>());
	Dispositivo tv = new Dispositivo("tv", 12, true, 10);
	Dispositivo aire = new Dispositivo("aire", 80, false, 2);
	Dispositivo homeTheater = new Dispositivo("home theater", 100, true, 1);
}
