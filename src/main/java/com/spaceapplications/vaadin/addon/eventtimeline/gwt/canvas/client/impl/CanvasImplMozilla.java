/*
 * Copyright 2008-2009 Oliver Zoran
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.spaceapplications.vaadin.addon.eventtimeline.gwt.canvas.client.impl;

import java.util.Stack;

/**
 * The Mozilla/Firefox implementation of the canvas widget.
 */
public class CanvasImplMozilla extends CanvasImpl {

	private Stack<Double> globalAlphaStack = new Stack<Double>();

	private double globalAlpha = 1.0;

	public void restore() {
		super.restore();
		if (!globalAlphaStack.isEmpty()) {
			setGlobalAlpha(globalAlphaStack.pop());
		}
	}

	public void save() {
		super.save();
		globalAlphaStack.push(globalAlpha);
	}

	public void setGlobalAlpha(double globalAlpha) {
		super.setGlobalAlpha(globalAlpha);
		this.globalAlpha = globalAlpha;
	}
}
