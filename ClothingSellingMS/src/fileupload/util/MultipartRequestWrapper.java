package fileupload.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
 
public class MultipartRequestWrapper extends HttpServletRequestWrapper {
 
    //�洢�����ļ���
    private Map<String,String[]> params = new HashMap<String, String[]>();
 
    private String PATH = "D:/ClothingSellingMS/ClothingSellingMS/WebContent/uploaded_images/"; //�����ϴ�·��
 
    public MultipartRequestWrapper(HttpServletRequest request) {
        super(request);
        setParams(request);//��request���н���,������map��
    }
    
    public MultipartRequestWrapper(HttpServletRequest request, String PATH) {
        super(request);
        this.PATH = PATH ;
        setParams(request);//��request���н���,������map��
    }
 
    /**
     * ͨ��StreamingAPI�ķ�ʽ�ϴ��ļ�
     */
    private void setParams(HttpServletRequest request){
        //��ȡ�ϴ��ļ�����
        if (ServletFileUpload.isMultipartContent(request)){
            //����ServletFileUploadʵ��
            ServletFileUpload fileUpload = new ServletFileUpload();
            try {
                //����request���� ����FileItemStream��iteratorʵ��
                FileItemIterator iter = fileUpload.getItemIterator(request);
                InputStream is = null;//�����
                //����ȡ��
                while (iter.hasNext()){
                    FileItemStream item = iter.next();//��ȡ�ļ���
                    String name = item.getFieldName();//���ر��б�ǩ��nameֵ
                    is = item.openStream();//�õ���Ӧ���������
                    if (item.isFormField()){//����Ƿ��ļ���,���ý���map,����Ҫע���ֵ����
                        setFormParam(name,is);//��������ļ��ϴ�,����
                    }else {
                        if (is.available()>0){//�������������ݴ���0
                            String fname = item.getName();//��ȡ�ļ���
                            Streams.copy(is,new FileOutputStream(PATH+fname),true);//�������ݵ��ϴ�·��
                            params.put(name,new String[]{fname});//���ļ������ý�request��
                        }
 
                    }
                }
 
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            params = request.getParameterMap();//��������ļ��ϴ�����,��ֱ������map
        }
    }
 
    /**
     * ������ϴ��ı�
     * @param name
     * @param is
     */
    private void setFormParam(String name, InputStream is) {
        try {
            if (params.containsKey(name)){//�жϵ�ǰֵname�Ƿ��Ѿ��洢��
                String[] values = params.get(name);//ȡ���Ѿ��洢����ֵ
                values = Arrays.copyOf(values,values.length+1);//�ѵ�ǰ��������
                values[values.length-1] = Streams.asString(is);//������ֵ
                params.put(name,values);//������ӵ�map��
            }else {
                params.put(name,new String[]{Streams.asString(is)});//ֱ�Ӵ��������
            }
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    /**
     * ���ز���map����,�Զ�����ϴ��ļ�,�ϴ��ɹ��򷵻��ļ���
     * @return
     */
    @Override
    public Map<String,String[]> getParameterMap() {
        return params;
    }
 
    /**
     * ��������ȡ������
     * @param name
     * @return
     */
    @Override
    public String getParameter(String name) {
        String[] values = params.get(name);
        if(values!=null) {
            return values[0];
        }
        return null;
    }
 
    /**
     * ��������ȡ���������ֵ,��checkbox��ֵ
     * @param name
     * @return
     */
    @Override
    public String[] getParameterValues(String name) {
        String[] values = params.get(name);
        if(values!=null) {
            return values;
        }
        return null;
    }
 
}