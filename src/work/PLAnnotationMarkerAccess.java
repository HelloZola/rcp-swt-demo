package work;
/* 
 * Copyright (c) 2022 Huawei Technologies Co.,Ltd.
 *
 * openGauss is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 *
 *           http://license.coscl.org.cn/MulanPSL2
 *        
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND,
 * EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT,
 * MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */

import java.util.Optional;

import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.ImageUtilities;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.ui.texteditor.DefaultMarkerAnnotationAccess;

/**
 * 
 * Title: class
 * 
 * Description: The Class PLAnnotationMarkerAccess.
 *
 * @since 3.0.0
 */
public class PLAnnotationMarkerAccess extends DefaultMarkerAnnotationAccess {

    /**
     * Gets the type label.
     *
     * @param annotation the annotation
     * @return the type label
     */
    @Override
    public String getTypeLabel(Annotation annotation) {
        if (annotation instanceof AnnotationWithLineNumber) {
            return "BREAKPOINT_ANNOTATION_LABEL";
        } else {
            return super.getTypeLabel(annotation);
        }
    }

    /**
     * Gets the layer.
     *
     * @param annotation the annotation
     * @return the layer
     */
    @Override
    public int getLayer(Annotation annotation) {
        if (annotation instanceof AnnotationWithLineNumber) {
            return 1;
        }
        return super.getLayer(annotation);
    }

    /**
     * Paint.
     *
     * @param annotation the annotation
     * @param gc the gc
     * @param canvas the canvas
     * @param bounds the bounds
     */
    @Override
    public void paint(Annotation annotation, GC gc, Canvas canvas, Rectangle bounds) {
        Optional<Image> paintImage = Optional.empty();
        if (annotation instanceof AnnotationWithLineNumber) {
            paintImage = ((AnnotationWithLineNumber) annotation).getImage();
        }

        if (paintImage.isPresent()) {
            ImageUtilities.drawImage(paintImage.get(), gc, canvas, bounds, SWT.CENTER, SWT.CENTER);
        } else {
            super.paint(annotation, gc, canvas, bounds);
        }

    }

    /**
     * Checks if is paintable.
     *
     * @param annotation the annotation
     * @return true, if is paintable
     */
    @Override
    public boolean isPaintable(Annotation annotation) {
        if (annotation instanceof AnnotationWithLineNumber) {
            return ((AnnotationWithLineNumber) annotation).getImage().isPresent();
        }
        return super.isPaintable(annotation);
    }

    /**
     * Checks if is multi line.
     *
     * @param annotation the annotation
     * @return true, if is multi line
     */
    @Override
    public boolean isMultiLine(Annotation annotation) {
        return false;
    }

}
