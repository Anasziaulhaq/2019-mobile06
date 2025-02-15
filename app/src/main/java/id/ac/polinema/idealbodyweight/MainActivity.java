package id.ac.polinema.idealbodyweight;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import id.ac.polinema.idealbodyweight.Fragments.AboutFragment;
import id.ac.polinema.idealbodyweight.Fragments.BmiFragment;
import id.ac.polinema.idealbodyweight.Fragments.BrocaIndexFragment;
import id.ac.polinema.idealbodyweight.Fragments.MenuFragment;
import id.ac.polinema.idealbodyweight.Fragments.ResultFragment;

public class MainActivity extends AppCompatActivity implements  MenuFragment.OnFragmentInteractionListener, BrocaIndexFragment.OnFragmentInteractionListener, ResultFragment.OnFragmentInteractionListener, BmiFragment.OnFragmentInteractionListener{


	private AboutFragment aboutFragment;
	private BrocaIndexFragment brocaIndexFragment;
	private ResultFragment resultFragment;
	private BmiFragment bmiFragment;
	MenuFragment menuFragment;



	// Deklarasikan atribut Fragment di sini


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		aboutFragment = AboutFragment.newInstance("Muhammad Anas Ziaulhaq");
		menuFragment = new MenuFragment();
		resultFragment = new ResultFragment();
		bmiFragment = new BmiFragment();
		brocaIndexFragment = new BrocaIndexFragment();
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, menuFragment)
				.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu, menu);
		return  true;
	}

	@Override
	public boolean onOptionsItemSelected(@NonNull MenuItem item) {
		// TODO: Tambahkan penanganan menu di sini
		if (item.getItemId() == R.id.menu_about) {
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.fragment_container, aboutFragment)
					.addToBackStack(null)
					.commit();
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onBrocaIndexButtonClicked() {
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, brocaIndexFragment)
				.commit();
	}


	@Override
	public void onBodyMassIndexButtonClicked() {
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container,bmiFragment )
				.commit();
	}

	@Override
	public void onCalculateBrocaIndexClicked(float index) {
		resultFragment.setInformation(String.format("Your ideal weight is %.2f kg", index));
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, resultFragment)
				.commit();
	}

	@Override
	public void onTryAgainButtonClicked(String tag) {
		if (tag.equals("BrocaIndex")) {
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.fragment_container, brocaIndexFragment)
					.commit();
		} else {
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.fragment_container, bmiFragment)
					.commit();
		}
	}

	@Override
	public void onCalculateBodyMassIndexClicked(String index) {
		resultFragment.setInformation("" + index);
		resultFragment.setStatus("BodyMassIndex");
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, resultFragment)
				.commit();
	}
}
