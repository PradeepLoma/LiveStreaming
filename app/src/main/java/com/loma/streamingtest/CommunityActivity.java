package com.loma.streamingtest;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.util.Log;

import io.agora.agorauikit_android.AgoraConnectionData;
import io.agora.agorauikit_android.AgoraSettings;
import io.agora.agorauikit_android.AgoraVideoViewer;
import io.agora.rtc2.Constants;

public class CommunityActivity extends AppCompatActivity {

    // Object of AgoraVideoVIewer class
    private AgoraVideoViewer agView = null;

    // Fill the App ID of your project generated on Agora Console.
    private final String appId = "05c9ae4220f34398a4fd6c743c0a9b77";
    // Fill the channel name.
    private String channelName = "lomaTesting";
    private String token = "007eJxTYNh0b8l5jmmdsSvkag2+RkZJRceVrt3El7frgP3T3VpVYp8UGAxMky0TU02MjAzSjE2MLS0STdJSzJLNTYyTDRItk8zNK+89SmkIZGRw6mZjYmRgZGABYhCfCUwyg0kWMMnNkJOfmxiSWlySmZfOwAAAm+wkzA==";
    // Fill the temp token generated on Agora Console.
    // An integer that identifies the local user.


    private void initializeAndJoinChannel() {
        // Create AgoraVideoViewer instance
        try {
            agView = new AgoraVideoViewer(this, new AgoraConnectionData(appId, token), AgoraVideoViewer.Style.FLOATING, new AgoraSettings(), null);
        } catch (Exception e) {
            Log.e("AgoraVideoViewer",
                    "Could not initialize AgoraVideoViewer. Check that your app Id is valid.");
            Log.e("Exception", e.toString());
            return;
        }

        // Add the AgoraVideoViewer to the Activity layout
        this.addContentView(agView, new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT)
        );

        // Check permission and join a channel
        joinChannel();
    }

    void joinChannel(){
        agView.join(channelName, token, Constants.CLIENT_ROLE_BROADCASTER, 0);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);
        initializeAndJoinChannel();
    }
}