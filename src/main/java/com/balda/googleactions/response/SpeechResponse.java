/*
 * Copyright 2017 Marco Stornelli <playappassistance@gmail.com>
 * 
 * This file is part of Google Actions project
 *
 * Google Actions is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Google Actions is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Google Actions.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.balda.googleactions.response;

import com.balda.googleactions.response.ResponseBuilder.SpeechElement;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SpeechResponse {

	@SerializedName("text_to_speech")
	@Expose
	private String textToSpeech;

	@SerializedName("ssml")
	@Expose
	private String ssml;

	public SpeechResponse(SpeechElement el) {
		if (el.isSsml())
			ssml = el.getPrompt();
		else
			textToSpeech = el.getPrompt();
	}

	public SpeechResponse() {
	}

	public String getSsml() {
		return ssml;
	}

	public void setSsml(String ssml) {
		this.ssml = ssml;
	}

	public String getTextToSpeech() {
		return textToSpeech;
	}

	public void setTextToSpeech(String textToSpeech) {
		this.textToSpeech = textToSpeech;
	}

}
