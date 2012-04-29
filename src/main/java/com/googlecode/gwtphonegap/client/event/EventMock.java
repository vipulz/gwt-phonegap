/*
 * Copyright 2011 Daniel Kurka
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.googlecode.gwtphonegap.client.event;

public interface EventMock {
	public void fireOfflineEvent();

	public void fireOnlineEvent();

	public void fireResumeEvent();

	public void firePauseEvent();

	public void fireBackEvent();

	public void fireSearchEvent();

	public void fireMenuEvent();

	public void fireBatteryCriticalEvent(int level, boolean plugged);

	public void fireBatteryLowEvent(int level, boolean plugged);

	public void fireBatteryStatusvent(int level, boolean plugged);

	public void fireStartCallButtonPressedEvent();

	public void fireEndCallButtonPressedEvent();

	public void fireVolumneButtonDownPressedEvent();

	public void fireVolumneButtonUpPressedEvent();
}
