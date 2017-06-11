package com.balda.apiai;

import java.util.List;

import com.balda.googleactions.response.ExpectedInput;
import com.balda.googleactions.response.ExpectedIntent;
import com.balda.googleactions.response.FinalResponse;
import com.balda.googleactions.response.InputPrompt;
import com.balda.googleactions.response.RichResponse;
import com.balda.googleactions.response.RootResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * When we use Api.Ai the webhook format is "nearly" the same but we can use the
 * fields: isSsml, speech, systemIntent, richResponse and finalResponse. Other
 * fields are don't care.
 */
public class GoogleApiAiBridge {
	@SerializedName("isSsml")
	@Expose
	private Boolean ssml;
	@SerializedName("speech")
	@Expose
	private String textTospeech;
	@SerializedName("systemIntent")
	@Expose
	private ExpectedIntent systemIntent;
	@SerializedName("richResponse")
	@Expose
	private RichResponse richResponse;
	@SerializedName("finalResponse")
	@Expose
	private FinalResponse finalResponse;
	@SerializedName("expectUserResponse")
	@Expose
	private Boolean expectUserResponse;

	public Boolean getExpectUserResponse() {
		return expectUserResponse;
	}

	public void setExpectUserResponse(Boolean expectUserResponse) {
		this.expectUserResponse = expectUserResponse;
	}

	public Boolean getSsml() {
		return ssml;
	}

	public void setSsml(Boolean ssml) {
		this.ssml = ssml;
	}

	public String getTextTospeech() {
		return textTospeech;
	}

	public void setTextTospeech(String textTospeech) {
		this.textTospeech = textTospeech;
	}

	public ExpectedIntent getSystemIntent() {
		return systemIntent;
	}

	public void setSystemIntent(ExpectedIntent systemIntent) {
		this.systemIntent = systemIntent;
	}

	public RichResponse getRichResponse() {
		return richResponse;
	}

	public void setRichResponse(RichResponse richResponse) {
		this.richResponse = richResponse;
	}

	public FinalResponse getFinalResponse() {
		return finalResponse;
	}

	public void setFinalResponse(FinalResponse finalResponse) {
		this.finalResponse = finalResponse;
	}

	public static GoogleApiAiBridge convert(RootResponse r) {
		GoogleApiAiBridge b = new GoogleApiAiBridge();
		b.setFinalResponse(r.getFinalResponse());
		b.setExpectUserResponse(r.getExpectUserResponse());
		List<ExpectedInput> l = r.getExpectedInputs();
		if (l != null && !l.isEmpty()) {
			ExpectedInput el = l.get(0);
			if (el != null) {
				List<ExpectedIntent> li = el.getPossibleIntents();
				if (li != null && !li.isEmpty())
					b.setSystemIntent(li.get(0));
				InputPrompt ip = el.getInputPrompt();
				if (ip != null)
					b.setRichResponse(ip.getRichInitialPrompt());
			}
		}
		return b;
	}
}