package mzta.com.bottomsheet;

import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button displayBottomSheetButton;
    Button displayBottomSheetModalButton;
    private BottomSheetBehavior mBottomSheetBehavior;
    View bottomSheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeLayoutResources();

    }

    private  void initializeLayoutResources(){
        bottomSheet = findViewById(R.id.bottom_sheet);
        mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        displayBottomSheetButton = (Button) findViewById(R.id.display_bottom_sheet_button);
        displayBottomSheetModalButton = (Button) findViewById(R.id.display_bottom_sheet_fragment_button);
        displayBottomSheetButton.setOnClickListener(this);
        displayBottomSheetModalButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.display_bottom_sheet_button: {
                if (mBottomSheetBehavior.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
                    mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                } else {
                    mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }
            break;

            case R.id.display_bottom_sheet_fragment_button: {
                final SampleBottomSheetDialogFragment myBottomSheet = SampleBottomSheetDialogFragment.newInstance(" Bottom Sheet Fragment");
                        myBottomSheet.show(getSupportFragmentManager(), myBottomSheet.getTag());

            }
            break;


        }
    }
}

