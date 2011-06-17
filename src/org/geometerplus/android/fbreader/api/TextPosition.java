/*
 * Copyright (C) 2010-2011 Geometer Plus <contact@geometerplus.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA.
 */

package org.geometerplus.android.fbreader.api;

import android.os.Parcel;
import android.os.Parcelable;

public final class TextPosition implements Parcelable {
	public final int ParagraphIndex;
	public final int ElementIndex;
	public final int CharIndex;

	TextPosition(int paragraphIndex, int elementIndex, int charIndex) {
		ParagraphIndex = paragraphIndex;
		ElementIndex = elementIndex;
		CharIndex = charIndex;
	}

	public int describeContents() {
		return 0;
	}

	public void writeToParcel(Parcel parcel, int flags) {
		parcel.writeInt(ParagraphIndex);
		parcel.writeInt(ElementIndex);
		parcel.writeInt(CharIndex);
	}

	public static final Parcelable.Creator<TextPosition> CREATOR =
		new Parcelable.Creator<TextPosition>() {
			public TextPosition createFromParcel(Parcel parcel) {
				return new TextPosition(parcel.readInt(), parcel.readInt(), parcel.readInt());
			}

			public TextPosition[] newArray(int size) {
				return new TextPosition[size];
			}
		};
}
