package com.ctci;

import java.util.Objects;

public class Septa {
	private static final byte[] SEPARATOR_BYTE_ARRAY = null;

	public static void main(String[] args) {
			
		Byte [] bytearray = new Byte[args.length];
	
		 ByteBuf buf = new ByteBuf();
		for(int i=0;i<args.length-1;++i) {
			 buf.add(args[i].getBytes(),SEPARATOR_BYTE_ARRAY);
		}
		
	    

	}
}
class ByteBuf
{
	public static byte[] grow(byte [] array, final int size) {
	    Objects.requireNonNull(array);

	    byte [] newArray  = new byte[array.length + size];
	    System.arraycopy(array, 0, newArray, 0, array.length);
	    return newArray;
	}



	public static byte[] grow(byte [] array) {
	    Objects.requireNonNull(array);

	    byte [] newArray  = new byte[array.length *2];
	    System.arraycopy(array, 0, newArray, 0, array.length);
	    return newArray;
	}


	public static byte[] shrink(byte[] array, int size) {
	    Objects.requireNonNull(array);

	    byte[] newArray = new byte[array.length - size];

	    System.arraycopy(array, 0, newArray, 0, array.length-size);
	    return newArray;
	}




	public static byte[] copy(byte[] array) {
	    Objects.requireNonNull(array);
	    byte[] newArray = new byte[array.length];
	    System.arraycopy(array, 0, newArray, 0, array.length);
	    return newArray;
	}


	public static byte[] add(byte[] array, byte v) {
	    Objects.requireNonNull(array);
	    byte[] newArray = new byte[array.length + 1];
	    System.arraycopy(array, 0, newArray, 0, array.length);
	    newArray[array.length] = v;
	    return newArray;
	}

	public static byte[] add(byte[] array, byte[] array2) {
	    Objects.requireNonNull(array);
	    byte[] newArray = new byte[array.length + array2.length];
	    System.arraycopy(array, 0, newArray, 0, array.length);
	    System.arraycopy(array2, 0, newArray, array.length, array2.length);
	    return newArray;
	}



	public static byte[] insert(final byte[] array, final int idx, final byte v) {
	    Objects.requireNonNull(array);

	    if (idx >= array.length) {
	        return add(array, v);
	    }

	    final int index = calculateIndex(array, idx);
	    byte [] newArray = new byte[array.length+1];

	    if (index != 0) {
	        System.arraycopy( array,   0,      newArray, 0,       index );
	    }


	    boolean lastIndex = index == array.length -1;
	    int remainingIndex = array.length - index;

	    if (lastIndex ) {
	        System.arraycopy(array, index,   newArray, index + 1, remainingIndex );

	    } else {
	        System.arraycopy(array, index,   newArray, index + 1, remainingIndex );

	    }

	    newArray[index] = v;
	    return  newArray;
	}


	public static byte[] insert(final byte[] array, final int fromIndex, final byte[] values) {
	    Objects.requireNonNull(array);

	    if (fromIndex >= array.length) {
	        return add(array, values);
	    }

	    final int index = calculateIndex(array, fromIndex);
	    byte [] newArray = new byte[array.length +  values.length];

	    if (index != 0) {
	        System.arraycopy( array,   0,      newArray, 0,       index );
	    }


	    boolean lastIndex = index == array.length -1;

	    int toIndex = index + values.length;
	    int remainingIndex = newArray.length - toIndex;

	    if (lastIndex ) {
	        System.arraycopy(array, index,   newArray, index + values.length, remainingIndex );

	    } else {
	        System.arraycopy(array, index,   newArray, index + values.length, remainingIndex );

	    }

	    for (int i = index, j=0; i < toIndex; i++, j++) {
	        newArray[ i ] = values[ j ];
	    }
	    return  newArray;
	}
	private static int calculateIndex( byte[] array, int originalIndex ) {
        final int length = array.length;



        int index = originalIndex;

        if ( index < 0 ) {
            index = length + index;
        }

        if ( index < 0 ) {
            index = 0;
        }
        if ( index >= length ) {
            index = length - 1;
        }
        return index;
    }
}