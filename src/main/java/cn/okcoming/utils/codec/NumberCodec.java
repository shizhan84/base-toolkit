package cn.okcoming.utils.codec;

/**
 *  字节和数字的转换
 * */
public interface NumberCodec {
     int bytes2Int(byte[] bytes, int byteLength) ;

     long bytes2Long(byte[] bytes, int byteLength) ;

     short bytes2Short(byte[] bytes, int byteLength);

     byte[] int2Bytes(int value, int byteLength);

     byte[] long2Bytes(long value, int byteLength) ;

     byte[] short2Bytes(short value, int byteLength) ;

     String convertCharset(String charset) ;
}
